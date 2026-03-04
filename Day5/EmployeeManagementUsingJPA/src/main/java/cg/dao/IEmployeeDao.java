package cg.dao;

import cg.bean.Employee;

import java.util.List;

public interface IEmployeeDao {
    public String saveEmployee(Employee emp);
    public Employee findEmployee(String empid);
    public List<Employee> getAll();
    public String updateEmployeeName(String empid, String newName);
    public String deleteEmployee(String empid);
}
