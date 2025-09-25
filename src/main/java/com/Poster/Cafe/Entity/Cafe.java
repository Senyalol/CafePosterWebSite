package com.Poster.Cafe.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cafe")
public class Cafe {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cafe_id_gen")
    @SequenceGenerator(name = "cafe_id_gen", sequenceName = "image_cafe_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

}
