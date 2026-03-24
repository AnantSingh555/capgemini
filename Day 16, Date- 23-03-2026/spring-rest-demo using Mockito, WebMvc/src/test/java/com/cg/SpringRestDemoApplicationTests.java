package com.cg;

import com.cg.dao.IEmployeeRepo;
import com.cg.dto.EmployeeDTO;
import com.cg.dto.EntityMapper;
import com.cg.entity.Employee;
import com.cg.exception.EmployeeNotFoundException;
import com.cg.service.EmployeeService;
import com.cg.service.IEmployeeService;
import org.hibernate.metamodel.mapping.EntityAssociationMapping;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
//import static org.springframework.test.web.client.ExpectedCount.times;

@ExtendWith(MockitoExtension.class)

@SpringBootTest
class SpringRestDemoApplicationTests {
//    @Autowired
    @Mock
    private IEmployeeRepo repo;
    @InjectMocks
    private EmployeeService service;
//    @Test
//    void testEmployeeById() {
//        assertNotNull(service.getEmployee(152));
//        assertThrows(EmployeeNotFoundException.class, ()->service.getEmployee(222));
//        assertEquals("Aryan", service.getEmployee(204).getFullName());
//    }

    @Test
    void testEmployeeById(){
        EmployeeDTO eDto=new EmployeeDTO("Avinash", LocalDate.of(2004, 02, 11), 25624.2);
        eDto.setEmployeeId(1001);
        Employee emp= EntityMapper.convertObjectToEntity(eDto);
        Optional<Employee> op= Optional.of(emp);
        when(repo.findById(1001)).thenReturn(op);
        assertNotNull(service.getEmployee(1001));

    }

    @Test
    void testEmployeeByIdWithException(){
        when(repo.findById(1004)).thenThrow(EmployeeNotFoundException.class);
        assertThrows(EmployeeNotFoundException.class, ()->service.getEmployee(1004));
    }

    @Test
    void testAllEmployee(){
        EmployeeDTO emp1=new EmployeeDTO("Aryan", LocalDate.of(2004, 12, 10), 20000.0);
        emp1.setEmployeeId(204);
        EmployeeDTO emp2=new EmployeeDTO("Avinash", LocalDate.of(2004, 02, 11), 25624.2);
        emp2.setEmployeeId(1001);
        List<Employee> lemp=new ArrayList<>();
        lemp.add(EntityMapper.convertObjectToEntity(emp1));
        lemp.add(EntityMapper.convertObjectToEntity(emp2));
        when(repo.findAll()).thenReturn(lemp);
        assertNotNull(service.getAllEmployee());
    }

    @Test
    void testAllEmployeeByName(){
        EmployeeDTO emp1=new EmployeeDTO("Aryan", LocalDate.of(2004, 12, 10), 20000.0);
        emp1.setEmployeeId(204);
        List<Employee> lemp=new ArrayList<>();
        lemp.add(EntityMapper.convertObjectToEntity(emp1));
        when(repo.findByName("Aryan")).thenReturn(lemp);
        assertNotNull(service.getEmployeeByName("Aryan"));
    }

    @Test
    void testRemoveEmployee(){
        EmployeeDTO eDto=new EmployeeDTO("Aryan", LocalDate.of(2004, 12, 10), 20000.0);
        eDto.setEmployeeId(204);
        Employee emp=EntityMapper.convertObjectToEntity(eDto);
        when(repo.findById(204)).thenReturn(Optional.of(emp));
        String result=service.removeEmployee(204);
        assertNotNull(result);
        assertEquals("Employee Deleted !!!",result);
    }

    @Test
    void testUpdateEmployee(){
        EmployeeDTO eDto = new EmployeeDTO("Avinash", LocalDate.of(2004, 02, 11), 25624.2);
        eDto.setEmployeeId(1001);
        Employee emp = EntityMapper.convertObjectToEntity(eDto);
        when(repo.findById(1001)).thenReturn(Optional.of(emp));
        when(repo.saveAndFlush(any(Employee.class))).thenReturn(emp);
        EmployeeDTO result=service.updateEmployee(eDto);
//        assertNotNull(result);
//        assertEquals("Avinash", result.getFullName());
        ArgumentCaptor<Employee> captor = ArgumentCaptor.forClass(Employee.class);

        verify(repo).saveAndFlush(captor.capture());

        Employee savedEmp = captor.getValue();
        assertEquals("Avinash", savedEmp.getName());

        //  verify behavior
//        verify(repo).findById(1004);
//        verify(repo, never()).saveAndFlush(any());
    }

    @Test
    void testCreateEmployee(){
        EmployeeDTO eDto = new EmployeeDTO("Avinash", LocalDate.of(2004, 02, 11), 25624.2);
        eDto.setEmployeeId(1001);
        Employee emp = EntityMapper.convertObjectToEntity(eDto);
        when(repo.saveAndFlush(any(Employee.class))).thenAnswer(i->i.getArgument(0));
        EmployeeDTO result=service.createEmployee(eDto);
        assertEquals("Avinash", result.getFullName());

        ArgumentCaptor<Employee> captor=ArgumentCaptor.forClass(Employee.class);
        verify(repo).saveAndFlush(captor.capture());
        Employee savedEmp=captor.getValue();

        assertEquals("Avinash", savedEmp.getName());
//        assertEquals(1001, savedEmp.getEmpId());


        verify(repo, times(1)).saveAndFlush(any(Employee.class));

    }

}
