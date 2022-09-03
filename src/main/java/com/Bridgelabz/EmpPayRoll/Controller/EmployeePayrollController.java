package com.Bridgelabz.EmpPayRoll.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Bridgelabz.EmpPayRoll.Model.EmployeePayrollModel;
import com.Bridgelabz.EmpPayRoll.Service.IEmployeePayrollService;
@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

	@Autowired
	private IEmployeePayrollService employeePayrollService;

	@GetMapping("")
	public String start() {

		return employeePayrollService.start();
	}

	@GetMapping("/getEmployee/{id}")
	public EmployeePayrollModel getEmployee(@PathVariable long id) {

		return employeePayrollService.getEmployeeById(id);
	}

	@PostMapping("/create")
	public EmployeePayrollModel create(@RequestBody EmployeePayrollModel emp) {
		EmployeePayrollModel emp1 = new EmployeePayrollModel();
		emp1.setName(emp.getName());
		emp1.setSalary(emp.getSalary());

		return employeePayrollService.createEmp(emp1);
	}

	@GetMapping("/getAll")
	public List<EmployeePayrollModel> getAll(){
		return employeePayrollService.getAll();
	}
	@PutMapping("/update/{id}")
	public EmployeePayrollModel update(@RequestBody EmployeePayrollModel emp, @PathVariable long id) {

		return employeePayrollService.update(emp, id);
	}
	
	@DeleteMapping("/deleteFromList/{id}")
	public void deleteFromList(@PathVariable long id) {
		employeePayrollService.deleteFromList(id);

	}
	
	@DeleteMapping("/delete/{id}")
	public EmployeePayrollModel delete(@PathVariable long id) {
		return employeePayrollService.delete(id);

	}

}