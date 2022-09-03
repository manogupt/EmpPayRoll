package com.Bridgelabz.EmpPayRoll.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bridgelabz.EmpPayRoll.Model.EmployeePayrollModel;

public interface IEmployeePayrollRepository extends JpaRepository<EmployeePayrollModel, Long>{

}