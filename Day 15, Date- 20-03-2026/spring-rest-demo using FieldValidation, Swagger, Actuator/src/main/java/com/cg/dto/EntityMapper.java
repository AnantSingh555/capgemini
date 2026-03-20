package com.cg.dto;

import com.cg.entity.Employee;

public class EntityMapper {
    public static Employee convertObjectToEntity(EmployeeDTO eDto){
        return new Employee(eDto.getFullName(), eDto.getDateOfBirth(), eDto.getSalary());
    }
    public static EmployeeDTO convertEntityToDto(Employee e){
        EmployeeDTO eDto=new EmployeeDTO(e.getName(), e.getDob(), e.getSalary());
        eDto.setEmployeeId(e.getEmpId());
        return eDto;
    }
}
