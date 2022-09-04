package com.Bridgelabz.EmpPayRoll.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Bridgelabz.EmpPayRoll.Dto.EmployeePayrollDto;
import com.Bridgelabz.EmpPayRoll.Model.EmployeePayrollModel;
import com.Bridgelabz.EmpPayRoll.Service.IEmployeePayrollService;
import com.Bridgelabz.EmpPayRoll.Util.Response;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@PostMapping("/create")
	public EmployeePayrollModel create(@Valid @RequestBody EmployeePayrollDto emp ,@RequestParam Long department_id ) {
		return employeePayrollService.createEmp(emp,department_id);
	}
	
	@GetMapping("/getlist")
	public List<EmployeePayrollModel> getList() {
		return employeePayrollService.getList();
	}
	
	@PostMapping("/login")
	public Response login(@RequestParam String mail,@RequestParam String pwd) {
		return employeePayrollService.login(mail,pwd);
	}
	
	@GetMapping("/getempbytoken")
	public EmployeePayrollModel getEmpByToken(@RequestHeader String token){
		return employeePayrollService.getEmpByToken(token);
	}

	@GetMapping("/getempwithid/{id}")
	public EmployeePayrollModel getEmployee(@PathVariable long id) {
		return employeePayrollService.getEmployeeById(id);
	}

	@GetMapping("/sortbyfirstname")
    public List<EmployeePayrollModel> sort(@PathVariable String content){
    	return employeePayrollService.getByContent(content);
    }

	
	@GetMapping("/sendmail/{id}")
	public void sendMail(@PathVariable long id) {
		employeePayrollService.sendMail(id);

	}
	
	@PutMapping("/setdepartment")
	public EmployeePayrollModel updateDepartment(@PathVariable long empId,@RequestParam long deptId) {
		return employeePayrollService.setDepartment(empId,deptId);

	}
	
	@PutMapping("/setdepartmenttotoken")
	public EmployeePayrollModel setDepartment(@RequestHeader String token,@RequestParam long deptId) {
		return employeePayrollService.setDepartmentToToken(token,deptId);

	}
	
	@PutMapping("/updatewithtoken")
	public EmployeePayrollModel updateWithToken(@RequestBody EmployeePayrollDto employeePayrollDto, @RequestHeader String token) {
		return employeePayrollService.updateWithToken(employeePayrollDto,token);

	}	
	@DeleteMapping("/delete/{id}")
	public EmployeePayrollModel delete(@PathVariable long id) {
		return employeePayrollService.delete(id);

	}
	
	@DeleteMapping("/deletewithtoken")
	public EmployeePayrollModel deleteWithToken(@RequestHeader String token) {
		return employeePayrollService.deleteWithToken(token);

	}


}