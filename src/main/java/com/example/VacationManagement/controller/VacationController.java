package com.example.VacationManagement.controller;

import com.example.VacationManagement.model.Employee;
import com.example.VacationManagement.model.Vacation;
import com.example.VacationManagement.service.EmployeeService;
import com.example.VacationManagement.service.VacationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class VacationController {

    private final VacationService service;

    private final EmployeeService employeeService;

    @GetMapping("/vacations")
    public List<Vacation> getAllVacations() {
        return service.getAll();
    }

    @PutMapping("/vacations")
    public List<Vacation> createOrUpdateVacations(@RequestBody List<Vacation> vacations) {
        return service.saveAll(vacations);
    }

    @GetMapping("/vacations/{id}")
    public Optional<Vacation> getVacationById(@PathVariable Long id) throws NoSuchElementException{
        return service.getById(id);
    }

    @DeleteMapping("/vacation/{id}")
    public void deleteVacationById(@PathVariable Long id) throws NoSuchElementException{
        service.deleteById(id);
    }

    @GetMapping("/employees/{id}/vacations")
    public List<Vacation> getEmployeeSVacations(@PathVariable Long id) throws NoSuchElementException {
        Employee employee = employeeService.getById(id).get();
        return service.getAll().stream().filter(vacation -> Objects.equals(vacation.getEmployee() ,employee))
                .collect(Collectors.toList());
    }
}
