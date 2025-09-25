package com.Poster.Cafe.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "vacancies")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vacancies_id_gen")
    @SequenceGenerator(name = "vacancies_id_gen", sequenceName = "vacancies_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "vacancies_name", nullable = false)
    private String vacanciesName;

    @Column(name = "salary", nullable = false, length = 100)
    private String salary;

    @ColumnDefault("false")
    @Column(name = "answer", nullable = false)
    private Boolean answer = false;

    @Column(name = "info", length = 1000)
    private String info;

}