package cg.dao;



import cg.bean.Employee;

import java.util.List;
public interface IEmployeeService {
    public String createEmployee(Employee emp);
    public Employee findById(String eid);
    public List<Employee> getAllEmployee();
    public String updateEmployeeName(String eid, String name);
    public String removeEmployee(String empid);
}
