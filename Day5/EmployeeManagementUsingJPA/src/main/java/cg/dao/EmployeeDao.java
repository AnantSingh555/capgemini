package cg.dao;


import cg.bean.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements IEmployeeDao {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    static{
        try{
            emf= Persistence.createEntityManagerFactory("my-pu");
            em=emf.createEntityManager();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public EmployeeDao() {
        super();
    }

    @Override
    public String saveEmployee(Employee emp) {
        EntityTransaction tx= em.getTransaction();
        try{
            tx.begin();
            em.persist(emp);
            tx.commit();
            return "Employee Created !";
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }
        return "Employee Not Created";
    }

    @Override
    public Employee findEmployee(String empid) {
        return em.find(Employee.class, empid);
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> li=em.createQuery("select e from Employee e", Employee.class).getResultList();
        return li;
    }

    @Override
    public String updateEmployeeName(String empid, String newName) {
        EntityTransaction tx= em.getTransaction();
        try{
            tx.begin();
            Employee emp=em.find(Employee.class, empid);
            if(emp!=null){
                emp.setName(newName);
                tx.commit();
                return "Employee Name changed successfully !";
            }else{
                return "Employee Not Found !";
            }
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }
        return "Update Failed !";
    }

    @Override
    public String deleteEmployee(String empid) {
        EntityTransaction tx=em.getTransaction();
        try{
            tx.begin();
            Employee emp=em.find(Employee.class, empid);
            if(emp!=null){
                em.remove(emp);
                tx.commit();
                return "Employee deleted successfully !";
            }else{
                return "Employee not found !";
            }
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }
        return "Deletion failed !";
    }
}
