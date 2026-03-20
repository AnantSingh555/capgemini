package com.cg.service;

import com.cg.dao.IEmployeeRepo;
import com.cg.dto.EmployeeDTO;
import com.cg.dto.EntityMapper;
import com.cg.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired
    private IEmployeeRepo repo;

//    public EmployeeService(IEmployeeRepo repo) {
//        this.repo = repo;
//    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> emps=repo.findAll();
        List<EmployeeDTO> empDTOs=new ArrayList<EmployeeDTO>();
        emps.forEach(e->empDTOs.add(EntityMapper.convertEntityToDto(e)));
        return empDTOs;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO e) {

        Employee emp=repo.saveAndFlush(EntityMapper.convertObjectToEntity(e));
        return EntityMapper.convertEntityToDto(emp);
    }

    @Override
    public EmployeeDTO getEmployee(int empId) {
        Optional<Employee> existing=repo.findById(empId);
        if(existing.isPresent()){
//            Employee e=existing.get();
//            return new EmployeeDTO(e.getEmpId(),e.getName(), e.getDob(), e.getSalary());
            return EntityMapper.convertEntityToDto(existing.get());
        }
        return EmployeeNotFoundException("Employee Not Found !!");
    }
    @Override
    public List<EmployeeDTO> getEmployeeByName(String name) {
        List<Employee> emps=repo.findByName(name);
        List<EmployeeDTO> empDTOs=new ArrayList<EmployeeDTO>();
        emps.forEach(e->empDTOs.add(EntityMapper.convertEntityToDto(e)));
        return empDTOs;
    }

    @Override
    public String removeEmployee(int empId) {
        if(getEmployee(empId)!=null){
            repo.deleteById(empId);
            return "Employee Deleted !!!";
        }
        else return "Employee Not Found !!";


    }

    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO e) {
        if(getEmployee(e.getEmployeeId())!=null){
            Employee emp= repo.saveAndFlush(EntityMapper.convertObjectToEntity(e));
            return EntityMapper.convertEntityToDto(emp);
        }
        else return null;

    }
}
