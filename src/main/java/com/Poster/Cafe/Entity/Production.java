package com.Poster.Cafe.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "production")
public class Production {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "production_id_gen")
    @SequenceGenerator(name = "production_id_gen", sequenceName = "production_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false, length = 100)
    private String type;

    @Column(name = "photo", length = 1000)
    private String photo;

    @Column(name = "info", length = 2000)
    private String info;

    @Column(name = "price", length = 100)
    private String price;

}