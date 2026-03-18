package com.cg.controller;

import com.cg.entity.Employee;
import com.cg.service.EmployeeService;
import com.cg.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService eService;

//    public EmployeeController(IEmployeeService eService) {
//        this.eService = eService;
//    }

    //    @GetMapping("/employees")
    @GetMapping
    public List<Employee> getEmployee(){
        return eService.getAllEmployee();
    }
    @GetMapping("/{empId}")
    public Employee getEmp(@PathVariable int empId){
        return eService.getEmployee(empId);
    }
    @GetMapping("nameIs/{name}")
    public List<Employee> getEmpName(@PathVariable String name){
        return eService.getEmployeeByName(name);
    }

    @PostMapping
    public Employee createNewEmployee(@RequestBody Employee emp){
        return eService.createEmployee(emp);
    }
    @DeleteMapping("/{empId}")
    public String removeEmployeeById(@PathVariable int empId){
        return eService.removeEmployee(empId);
    }
    @PutMapping
    public Employee updateEmp(@RequestBody Employee e){
        return eService.updateEmployee(e);
    }
}
