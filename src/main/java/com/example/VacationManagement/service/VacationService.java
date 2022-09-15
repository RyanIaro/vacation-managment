package com.example.VacationManagement.service;

import com.example.VacationManagement.model.Vacation;
import com.example.VacationManagement.repository.VacationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VacationService {

    private final VacationRepository repository;

    public List<Vacation> getByCriteria(String purpose, String employeeFirstName, String employeeLastName) {
        return repository.findAll()
                .stream()
                .filter(vacation -> vacation.getPurpose()
                        .toLowerCase()
                        .contains(purpose.toLowerCase()))
                .toList()
                .stream()
                .filter(vacation -> vacation.getEmployee()
                        .getFirstName()
                        .toLowerCase()
                        .contains(employeeFirstName.toLowerCase()))
                .toList()
                .stream()
                .filter(vacation -> vacation.getEmployee()
                        .getLastName()
                        .toLowerCase()
                        .contains(employeeLastName.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Vacation> getAll() {
        return repository.findAll();
    }

    public List<Vacation> saveAll(List<Vacation> vacations) {
        return repository.saveAll(vacations);
    }

    public Optional<Vacation> getById(Long vacationId) {
        return repository.findById(vacationId);
    }

    public void deleteById(Long vacationId) {
        repository.deleteById(vacationId);
    }

}
