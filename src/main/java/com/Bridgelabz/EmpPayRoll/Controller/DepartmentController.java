package com.Bridgelabz.EmpPayRoll.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Bridgelabz.EmpPayRoll.Dto.DepartmentDto;
import com.Bridgelabz.EmpPayRoll.Model.Department;
import com.Bridgelabz.EmpPayRoll.Service.IDepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    IDepartmentService departmentService;
    
    @PostMapping("create")
    public Department addDepartment(@RequestBody DepartmentDto departmentDto){
    	return departmentService.addDepartment(departmentDto);
    }

    @GetMapping("/read")
    public List<Department> getDepartments(){
    	return departmentService.getDepartments();
    }
    
    
    @GetMapping("/readbytoken")
    public Department getDepartmentByToken(@RequestHeader String token) {
    	return departmentService.getDepartmentByToken(token);
    }
    
    @PutMapping("/updatetoken/{id}")
    public Department updateDepartment(@RequestParam long id , @RequestBody DepartmentDto departmentDto) {
    	return departmentService.update(id,departmentDto);
    }
}