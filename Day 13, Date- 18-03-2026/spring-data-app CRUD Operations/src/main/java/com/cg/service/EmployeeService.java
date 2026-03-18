package com.cg.service;

import com.cg.entity.Employee;
import com.cg.repo.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private IEmployeeRepo erepo;
    public String createEmployee(Employee emp){
        Employee e=erepo.saveAndFlush(emp);
        return "Employee Created !! Your empId is "+ e.getEmpId();
    }
    public List<Employee> getEmployees(){
        return erepo.findAll();
    }
    public Employee getEmployee(int id){
        Optional<Employee> existing=erepo.findById(id);
        if(existing.isPresent()) return existing.get();
        else return null;
    }
    public String removeEmployee(int empId){
        if(getEmployee(empId)!=null){
            erepo.deleteById(empId);
            return "Employee Removed !!!";
        }
        else{
            return "Employee not found !!";
        }
    }
    public String updateEmployee(Employee e){

        if(getEmployee(e.getEmpId())!=null){
            erepo.saveAndFlush(e);
            return "Employee Updated !!";
        }
        else{
            return "Employee not found!!";
        }
    }
    public List<Employee> getEmployeeByName(String name){
//        return erepo.findByName(name);
        return erepo.findByNa(name);
    }
    public List<Employee> getEmployeeBySalary(double salary){
        return erepo.findBySalaryLessThanEqual(salary);
    }
    public List<Employee> getEmployeeByMonth(int month){
        return erepo.findByDobMonthEquals(1);
    }

}
