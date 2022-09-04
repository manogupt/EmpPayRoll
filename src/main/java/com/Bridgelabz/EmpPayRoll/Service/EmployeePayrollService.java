package com.Bridgelabz.EmpPayRoll.Service;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.Bridgelabz.EmpPayRoll.Dto.EmployeePayrollDto;
import com.Bridgelabz.EmpPayRoll.Exception.EmployeeNotFoundException;
import com.Bridgelabz.EmpPayRoll.Exception.MethodArgumentNotValidException;
import com.Bridgelabz.EmpPayRoll.Model.Department;
import com.Bridgelabz.EmpPayRoll.Model.EmployeePayrollModel;
import com.Bridgelabz.EmpPayRoll.Repository.IDepartmentRepository;
import com.Bridgelabz.EmpPayRoll.Repository.IEmployeePayrollRepository;
import com.Bridgelabz.EmpPayRoll.Util.Response;
import com.Bridgelabz.EmpPayRoll.Util.TokenUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

//	private List<EmployeePayrollModel> empList = new ArrayList<>();
	@Autowired
	IEmployeePayrollRepository repo;
	
	@Autowired
	IDepartmentRepository deptRepo;

	@Autowired
	TokenUtil tokenUtil;

	@Autowired
	MailService mailService;
	  
	@Override
	public String start() {
		return "Hello to Uc1";
	}

	@Override
	public List<EmployeePayrollModel> getList(){
		List<EmployeePayrollModel> getallemployee= repo.findAll();
        if(getallemployee.size() > 0)
        	return getallemployee;
        else
            throw new EmployeeNotFoundException(400, "No Data Present");	
	}
	
	@Override
	public EmployeePayrollModel getEmployeeById(long id) {
		
		Optional<EmployeePayrollModel> isEmpPresent = repo.findById(id);
		if(isEmpPresent.isPresent())
				return isEmpPresent.get();
		log.info("No Employee");
		throw new EmployeeNotFoundException(400, "No employee with id "+id+" is Present");
	}

	@Override
	public Response login(String email, String pwd) {
		Optional<EmployeePayrollModel> isemailPresent = repo.findByEmailId(email);
		if (isemailPresent.isPresent()) {
			if(isemailPresent.get().getPwd().equals(pwd)) {
				String token = tokenUtil.createToken(isemailPresent.get().getEmployeeID());
			return new Response("logged in Successfully", 222,token);
			}else
				throw new EmployeeNotFoundException(100,"cannot login");
		}
		throw new EmployeeNotFoundException(100,"emp not present");
	}
	
	@Override
	public EmployeePayrollModel getEmpByToken(String token) {
		Long empId=tokenUtil.decodeToken(token);
		Optional<EmployeePayrollModel> isEmployeePresent=repo.findById(empId);
		if(isEmployeePresent.isPresent()) {
			List<EmployeePayrollModel> getallemployee = repo.findAll();
			if (getallemployee.size() > 0)
				return isEmployeePresent.get();
			else
				throw new EmployeeNotFoundException(400, "No DATA Present");
		}
		throw new EmployeeNotFoundException(400,"Employee Not found");
	}

	@Override
	public EmployeePayrollModel createEmp(EmployeePayrollDto employeeDto,Long departmentId) {
		
//		Optional<EmployeePayRollModel> isEmpPresent = repo
		EmployeePayrollModel employeePayrollModel=new EmployeePayrollModel(employeeDto);	
        Optional<Department> isDepartmentPresent=deptRepo.findById(departmentId);		
        if(isDepartmentPresent.isPresent()) {
            employeePayrollModel.setDepartment(isDepartmentPresent.get());

        }
        repo.save(employeePayrollModel);
		
//		employeePayrollModel.setName(employeeDto.getName());
//		employeePayrollModel.setSalary(employeeDto.getSalary());
//		employeePayrollModel.setEmailId(employeeDto.getEmailId());
//		employeePayrollModel.setPwd(employeeDto.getPwd());		
		return employeePayrollModel;
	}

	@Override
	public EmployeePayrollModel update(EmployeePayrollDto emp, long empId,long deptId) {
		Optional<EmployeePayrollModel> emp2 = repo.findById(empId);
		if(emp2.isPresent()) {
			Optional<Department> isDeptPresent = deptRepo.findById(deptId); 
			if(isDeptPresent.isPresent()) {
			emp2.get().setName(emp.getName());
			emp2.get().setSalary(emp.getSalary());
			emp2.get().setEmailId(emp.getEmailId());
			emp2.get().setPwd(emp.getPwd());
			emp2.get().setDepartment(isDeptPresent.get());
			repo.save(emp2.get());
			return emp2.get();
			}else
				throw new EmployeeNotFoundException(400, "Department not present with id : "+deptId );
		}else
			throw new EmployeeNotFoundException(400, "Employee Not Present with id :"+empId );
	}

	@Override
	public EmployeePayrollModel delete(long id) {
		Optional<EmployeePayrollModel> emp = repo.findById(id);
		if(emp.isPresent()) {
		repo.delete(emp.get());
		return emp.get();
		}
		else
			throw new EmployeeNotFoundException(400, "No DATA Present");
	}

	@Override
	public void sendMail(long id) {
		Optional<EmployeePayrollModel> emp = repo.findById(id);
		if(emp.isPresent()) {
			String body="Employee is added succesfully with employeeId ";
			String subject="Employee Registration Succesfull";
			mailService.send("piyushp054@gmail.com",subject,body);
		}else
			throw new EmployeeNotFoundException(400, "No Employee Present with id :"+id);
	}

	@Override
	public EmployeePayrollModel updateWithToken(String token) {
		Long empId=tokenUtil.decodeToken(token);
		Optional<EmployeePayrollModel> isEmpPresent = repo.findById(empId);
		if(isEmpPresent.isPresent()) {
			List<EmployeePayrollModel> getallemployee = repo.findAll();
			if (getallemployee.size() > 0)
				return isEmpPresent.get();
			else
				throw new EmployeeNotFoundException(400, "No DATA Present");
		}
		throw new EmployeeNotFoundException(400,"Employee Not found");
	}

	@Override
	public EmployeePayrollModel deleteWithToken(String token) {
		Long empId=tokenUtil.decodeToken(token);
		Optional<EmployeePayrollModel> isEmpPresent = repo.findById(empId);
		if(isEmpPresent.isPresent()) {
			List<EmployeePayrollModel> getallemployee = repo.findAll();
			if (getallemployee.size() > 0) {
				repo.delete(isEmpPresent.get());
				return isEmpPresent.get();
			}
			else
				throw new EmployeeNotFoundException(400, "No DATA Present");
		}
		throw new EmployeeNotFoundException(400,"Employee Not found");
	}

	@Override
	public EmployeePayrollModel updateDepartmentWithToken(EmployeePayrollDto emp, String token, long deptId) {
		Long empId=tokenUtil.decodeToken(token);
		Optional<Department> isDeptPresent = deptRepo.findById(deptId); 
		Optional<EmployeePayrollModel> emp2 = repo.findById(empId);
		emp2.get().setName(emp.getName());
		emp2.get().setSalary(emp.getSalary());
		emp2.get().setEmailId(emp.getEmailId());
		emp2.get().setPwd(emp.getPwd());
		emp2.get().setDepartment(isDeptPresent.get());
		repo.save(emp2.get());
		return emp2.get();
	}

	@Override
	public List<EmployeePayrollModel> getByContent(String content) {
		
		List<EmployeePayrollModel> list = repo.findAll();
		List<EmployeePayrollModel> list1 = new ArrayList<>();
		
		for(EmployeePayrollModel emp: list) {
			if(emp.getName().contains(content))
				list1.add(emp);
		}
		return list1;
	}
	
}