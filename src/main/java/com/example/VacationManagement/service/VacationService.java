package com.example.VacationManagement.service;

import com.example.VacationManagement.model.Vacation;
import com.example.VacationManagement.repository.VacationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VacationService {

    private final VacationRepository repository;

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
