package com.Poster.Cafe.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "info")
public class Info {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "info_id_gen")
    @SequenceGenerator(name = "info_id_gen", sequenceName = "info_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "info", nullable = false, length = 5000)
    private String info;

}