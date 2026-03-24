package com.cg.controller;

import com.cg.dto.EmployeeDTO;
import com.cg.entity.Employee;
import com.cg.service.EmployeeService;
import com.cg.service.IEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
@Tag(name="EmployeeAPI", description="This provides the CRUD operations with Employee Entity")
public class EmployeeController {
    @Autowired
    private IEmployeeService eService;

//    public EmployeeController(IEmployeeService eService) {
//        this.eService = eService;
//    }

    //    @GetMapping("/employees")
    @GetMapping(produces={"application/json", "application/xml"})
    @Operation(summary="This API will provide all employee details from MySQL DB")
    public List<EmployeeDTO> getEmployee(){
        return eService.getAllEmployee();
    }
    @GetMapping("/{empId}")
    public EmployeeDTO getEmp(@PathVariable int empId){
        EmployeeDTO e=eService.getEmployee(empId);
//        if(e!=null){
//            return new ResponseEntity<EmployeeDTO>(e, HttpStatus.OK);
//        }
//        else return new ResponseEntity<EmployeeDTO>((EmployeeDTO) null, HttpStatus.NOT_FOUND);
        return e;
    }
    @GetMapping("nameIs/{name}")
    public List<EmployeeDTO> getEmpName(@PathVariable String name){
        return eService.getEmployeeByName(name);
    }

    @PostMapping(consumes={"application/json", "application/xml"})
    public EmployeeDTO createNewEmployee(@RequestBody @Valid EmployeeDTO emp){
        return eService.createEmployee(emp);
    }
    @DeleteMapping("/{empId}")
    public String removeEmployeeById(@PathVariable int empId){
        return eService.removeEmployee(empId);
    }
    @PutMapping
    public EmployeeDTO updateEmp(@RequestBody EmployeeDTO e){
        return eService.updateEmployee(e);
    }
}
