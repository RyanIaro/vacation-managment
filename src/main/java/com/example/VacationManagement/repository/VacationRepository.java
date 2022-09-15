package com.example.VacationManagement.repository;

import com.example.VacationManagement.model.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacationRepository extends JpaRepository<Vacation, Long> {
}
