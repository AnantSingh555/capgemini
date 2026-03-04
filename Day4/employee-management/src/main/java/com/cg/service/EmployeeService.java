package com.cg.service;

import com.cg.bean.Employee;
import com.cg.dao.EmployeeDao;
import com.cg.dao.IEmployeeDao;
import com.cg.dao.IEmployeeService;

import java.util.List;


public class EmployeeService implements IEmployeeService {
    private IEmployeeDao dao = new EmployeeDao();

    @Override
    public String createEmployee(Employee emp) {
        return dao.saveEmployee(emp);
    }

    @Override
    public Employee findById(String eid) {
        return dao.findEmployee(eid);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return dao.getAll();
    }

    @Override
    public String updateEmployeeName(String eid, String name) {
        return dao.updateEmployeeName(eid, name);
    }

    @Override
    public String removeEmployee(String empid) {
        return dao.deleteEmployee(empid);
    }
}
