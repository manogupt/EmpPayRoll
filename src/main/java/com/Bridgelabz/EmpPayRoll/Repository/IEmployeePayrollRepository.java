package com.Bridgelabz.EmpPayRoll.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bridgelabz.EmpPayRoll.Model.EmployeePayrollModel;

public interface IEmployeePayrollRepository extends JpaRepository<EmployeePayrollModel, Long>{

	Optional<EmployeePayrollModel> findByEmailId(String emailId);

}