package com.example.VacationManagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "\"Vacations\"")
@Getter
@Setter
@ToString
public class Vacation implements Serializable {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVacation;

    @Column(nullable = false)
    private LocalDate beginning;

    @Column(nullable = false)
    private LocalDate ending;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;
}
