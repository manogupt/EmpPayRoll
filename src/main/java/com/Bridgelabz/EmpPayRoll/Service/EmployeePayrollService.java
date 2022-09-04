package com.Bridgelabz.EmpPayRoll.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bridgelabz.EmpPayRoll.Dto.EmployeePayrollDto;
import com.Bridgelabz.EmpPayRoll.Exception.EmployeeNotFoundException;
import com.Bridgelabz.EmpPayRoll.Model.EmployeePayrollModel;
import com.Bridgelabz.EmpPayRoll.Repository.IEmployeePayrollRepository;
import com.Bridgelabz.EmpPayRoll.Util.Response;
import com.Bridgelabz.EmpPayRoll.Util.TokenUtil;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

//	private List<EmployeePayrollModel> empList = new ArrayList<>();
	@Autowired
	IEmployeePayrollRepository repo;

	@Autowired
	TokenUtil tokenUtil;

	@Autowired
	MailService mailService;
	  
	@Override
	public String start() {
		return "Hello to Uc1";
	}

	@Override
	public List<EmployeePayrollModel> getlist(){
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
	public EmployeePayrollModel getempbytoken(String token) {
		Long empId=tokenUtil.decodeToken(token);
		Optional<EmployeePayrollModel> isEmployeePresent=repo.findById(empId);
//		if(isEmployeePresent.isPresent()) {
//			List<EmployeePayrollModel> getallemployee = repo.findAll();
//			if (getallemployee.size() > 0)
				return isEmployeePresent.get();
//			else
	//			throw new EmployeeNotFoundException(400, "No DATA Present");
	//	}
	//	throw new EmployeeNotFoundException(400,"Employee Not found");
	}

	@Override
	public EmployeePayrollModel createEmp(EmployeePayrollDto employeeDto) {
		EmployeePayrollModel employeePayrollModel=new EmployeePayrollModel(employeeDto);				
		employeePayrollModel.setName(employeeDto.getName());
		employeePayrollModel.setSalary(employeeDto.getSalary());
		employeePayrollModel.setEmailId(employeeDto.getEmailId());
		employeePayrollModel.setPwd(employeeDto.getPwd());		
		repo.save(employeePayrollModel);
		return employeePayrollModel;
	}

	@Override
	public EmployeePayrollModel update(EmployeePayrollModel emp, long id) {
		Optional<EmployeePayrollModel> emp2 = repo.findById(id);
		emp2.get().setName(emp.getName());
		emp2.get().setSalary(emp.getSalary());
		emp2.get().setEmailId(emp.getEmailId());
		emp2.get().setPwd(emp.getPwd());
		repo.save(emp2.get());
		return emp2.get();
	}

	@Override
	public EmployeePayrollModel delete(long id) {
		Optional<EmployeePayrollModel> emp = repo.findById(id);
		repo.delete(emp.get());
		return emp.get();
	}

	@Override
	public void sendmail(long id) {
		Optional<EmployeePayrollModel> emp = repo.findById(id);
		String body="Employee is added succesfully with employeeId ";
	    String subject="Employee Registration Succesfull";
	    mailService.send("manojgupta123929@gmail.com",subject,body);
	}
}