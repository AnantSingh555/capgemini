package com.cg.repo;

import com.cg.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee,Integer> {
    @Query("select e from Employee e where e.name=:n")
//    public List<Employee> findByName(String name);
    public List<Employee> findByNa(@Param("n") String name);

    public List<Employee> findBySalaryLessThanEqual(double salary);

    @Query("select e from Employee e where Month(e.dob)=:m")
    public List<Employee> findByDobMonthEquals(@Param("m") int month);
}

