package com.cg;

import com.cg.controller.EmployeeController;
import com.cg.dto.EmployeeDTO;
import com.cg.dto.EntityMapper;
import com.cg.entity.Employee;
import com.cg.service.IEmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
@AutoConfigureJsonTesters
public class ControllerMockTesting {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IEmployeeService service;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getEmployeeByIdApiTest() throws Exception{
        EmployeeDTO eDto=new EmployeeDTO("Tushar", LocalDate.of(2005,12,4), 98542.24);
        when(service.getEmployee(1)).thenReturn(eDto);

        mockMvc.perform(get("/employees/1")).andExpect(status().isOk()).andExpect(jsonPath("$.fullName").value("Tushar"));
    }

    @Test
    void getAllEmployeeTest() throws Exception{
        EmployeeDTO emp1=new EmployeeDTO("Aryan", LocalDate.of(2004, 12, 10), 20000.0);
        emp1.setEmployeeId(204);
        EmployeeDTO emp2=new EmployeeDTO("Avinash", LocalDate.of(2004, 02, 11), 25624.2);
        emp2.setEmployeeId(1001);
        List<EmployeeDTO> lemp=new ArrayList<>();
        lemp.add(emp1);
        lemp.add(emp2);
        when(service.getAllEmployee()).thenReturn(lemp);
        mockMvc.perform(get("/employees")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fullName").value("Aryan"));
    }

    @Test
    void getEmpByNameTest() throws Exception{
        EmployeeDTO eDto=new EmployeeDTO("Tushar", LocalDate.of(2005,12,4), 98542.24);
        List<EmployeeDTO> lEmp=new ArrayList<>();
        lEmp.add(eDto);
        when(service.getEmployeeByName("Tushar")).thenReturn(lEmp);
        mockMvc.perform(get("/employees/nameIs/Tushar")).andExpect(status().isOk()).andExpect(jsonPath("$[0].fullName").value("Tushar"));
    }

    @Test
    void createEmpTest() throws Exception{
        EmployeeDTO input=new EmployeeDTO("Avinash", LocalDate.of(2004, 02, 11), 25624.2);
        EmployeeDTO output=new EmployeeDTO("Avinash", LocalDate.of(2004, 02, 11), 25624.2);
        output.setEmployeeId(1001);
        when(service.createEmployee(any(EmployeeDTO.class))).thenReturn(output);
        mockMvc.perform(post("/employees")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(input)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employeeId").value(1001))
                .andExpect(jsonPath("$.fullName").value("Avinash"));
    }

    @Test
    void removeEmployeeTest() throws Exception{
        when(service.removeEmployee(1001)).thenReturn("Employee Deleted !!!");
        mockMvc.perform(delete("/employees/1001"))
                .andExpect(status().isOk())
                .andExpect(content().string("Employee Deleted !!!"));
    }

    @Test
    void updateEmployeeTest() throws Exception{
        EmployeeDTO emp1=new EmployeeDTO("Aryan", LocalDate.of(2004, 12, 10), 20000.0);
        emp1.setEmployeeId(204);
        when(service.updateEmployee(any(EmployeeDTO.class))).thenReturn(emp1);
        mockMvc.perform(put("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(emp1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employeeId").value(204));
    }

}
