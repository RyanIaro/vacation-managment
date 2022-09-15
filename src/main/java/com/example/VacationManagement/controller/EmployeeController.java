package com.example.VacationManagement.controller;

import com.example.VacationManagement.model.Employee;
import com.example.VacationManagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@RestController
@CrossOrigin
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("/")
    public String welcome() {
        return "Hello world!";
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(
            @RequestParam(value = "firstName", required = false, defaultValue = "") String firstName,
            @RequestParam(value = "lastName", required = false, defaultValue = "") String lastName) {
        return service.getByCriteria(firstName, lastName);
    }

    @PutMapping("/employees")
    public List<Employee> createOrUpdateEmployees(@RequestBody List<Employee> employees) {
        return service.saveAll(employees);
    }

    @GetMapping("/employees/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id) throws NoSuchElementException{
        return service.getById(id);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable Long id) throws NoSuchElementException {
        service.deleteById(id);
    }
}
