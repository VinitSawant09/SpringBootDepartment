package com.vscode.Springboot.department.controller;

import com.vscode.Springboot.department.entity.Department;
import com.vscode.Springboot.department.error.DepartmentNotFoundException;
import com.vscode.Springboot.department.service.DepartmentService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Department Rest Endpoint")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    @Hidden
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    @Operation(summary = "Returns a department", description = "Takes Id  returns single department")
    public @ApiResponse(description = "Department Object") Department fetchDepartmentById(@Parameter(description = "Id of the department") @PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
         LOGGER.info("Inside fetchDepartmentById of DepartmentController");
         return departmentService.fetchDepartmentById(departmentId);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        LOGGER.info("Inside updateDepartment of DepartmentController");
        return departmentService.updateDepartment(departmentId,department);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        LOGGER.info("Inside deleteDepartmentById of DepartmentController");
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully";
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Inside fetchDepartmentByName of DepartmentController");
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
