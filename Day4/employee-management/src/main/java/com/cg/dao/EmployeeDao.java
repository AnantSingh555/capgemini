package com.cg.dao;

import com.cg.bean.Employee;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements IEmployeeDao {

    private static Connection con;
    static{
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "Anant@123");
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public EmployeeDao() {
        super();
    }

    @Override
    public String saveEmployee(Employee emp) {
        try{
            PreparedStatement ps=con.prepareStatement("insert into employee values (?,?,?,?,?)");
            ps.setString(1, emp.getEmpid());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getDesignation());
            ps.setString(4, emp.getLocation());
            ps.setString(5, emp.getPerformance());
            int rows= ps.executeUpdate();
            if(rows>0){
                return "Employee Created !";
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Employee Not Created";
    }

    @Override
    public Employee findEmployee(String empid) {
        Employee emp1=null;
        try{
            PreparedStatement ps=con.prepareStatement("Select * from employee where empId=?");
            ps.setString(1, empid);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                emp1.setEmpid(rs.getString("empId"));
                emp1.setName(rs.getString("empName"));
                emp1.setDesignation(rs.getString("designation"));
                emp1.setLocation(rs.getString("location"));
                emp1.setPerformance(rs.getString("performance"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return emp1;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> list= new ArrayList<>();
        try{
            PreparedStatement ps= con.prepareStatement("Select * from employee");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Employee emp=new Employee();
                emp.setEmpid(rs.getString("empId"));
                emp.setName(rs.getString("empName"));
                emp.setDesignation(rs.getString("designation"));
                emp.setLocation(rs.getString("location"));
                emp.setPerformance(rs.getString("performance"));
                list.add(emp);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String updateEmployeeName(String empid, String newName) {
        try{
            PreparedStatement ps=con.prepareStatement("Update employee set empName=? where empId=?");
            ps.setString(1,newName);
            ps.setString(2, empid);
            int rows=ps.executeUpdate();
            if(rows>0){
                return "Employee Name Updated Successfully";
            }
            else{
                return "Employee not found";
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Update Failed !";
    }

    @Override
    public String deleteEmployee(String empid) {
//        try {
//            PreparedStatement ps = con.prepareStatement(
//                    "DELETE FROM employee WHERE empId=?"
//            );
//
//            ps.setString(1, empid);
//
//            int rows = ps.executeUpdate();
//
//            if (rows > 0) {
//                return "Employee Deleted Successfully";
//            } else {
//                return "Employee Not Found";
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return "Deletion Failed";

//        Stored Procedure Approach
        try{
            CallableStatement cs= con.prepareCall("{Call del_employee(?)}");
            cs.setString(1, empid);
            int rows=cs.executeUpdate();
            if(rows>0){
                return "Employee deleted successfully !";
            }else{
                return "Employee not found !";
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return "Deletion failed !";
    }
}
