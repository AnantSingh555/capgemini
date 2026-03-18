package com.cg.service;

import com.cg.dao.IEmployeeRepo;
import com.cg.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Employee> getAllEmployee() {
        return repo.findAll();
    }

    @Override
    public Employee createEmployee(Employee e) {
        return repo.saveAndFlush(e);
    }

    @Override
    public Employee getEmployee(int empId) {
        Optional<Employee> existing=repo.findById(empId);
        if(existing.isPresent()){
            return existing.get();
        }
        return null;
    }
    @Override
    public List<Employee> getEmployeeByName(String name) {
        return repo.findByName(name);
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
    public Employee updateEmployee(Employee e) {
        if(getEmployee(e.getEmpId())!=null){
            return repo.saveAndFlush(e);
        }
        else return null;

    }
}
