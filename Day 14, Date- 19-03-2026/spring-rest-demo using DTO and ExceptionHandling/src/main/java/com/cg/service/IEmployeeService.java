package com.cg.service;

import com.cg.dto.EmployeeDTO;
import com.cg.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<EmployeeDTO> getAllEmployee();
    public EmployeeDTO createEmployee(EmployeeDTO e);
    public EmployeeDTO getEmployee(int empId);
    public List<EmployeeDTO> getEmployeeByName(String name);
    public String removeEmployee(int empId);
    public EmployeeDTO updateEmployee(EmployeeDTO e);
}
