package com.example.VacationManagement.service;

import com.example.VacationManagement.model.Employee;
import com.example.VacationManagement.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public List<Employee> getAll(String firstName, String lastName) {
        return repository.findAll()
                .stream()
                .filter(employee -> employee.getFirstName().toLowerCase().equals(firstName.toLowerCase())).toList()
                .stream()
                .filter(employee -> employee.getLastName().toLowerCase().equals(lastName.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Employee> saveAll(List<Employee> employees) {
        return repository.saveAll(employees);
    }

    public Optional<Employee> getById(Long employeeId){
        return repository.findById(employeeId);
    }

    public void deleteById(Long employeeId) {
        repository.deleteById(employeeId);
    }
}
