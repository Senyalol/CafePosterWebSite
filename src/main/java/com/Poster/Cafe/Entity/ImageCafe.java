package com.Poster.Cafe.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "image_cafe")
public class ImageCafe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_cafe_id_gen")
    @SequenceGenerator(name = "image_cafe_id_gen", sequenceName = "image_cafe_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "image", nullable = false, length = 1000)
    private String image;

}