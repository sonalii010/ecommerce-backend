package com.example.ecom_proj.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Data
@Getter
@Setter
public class Product {

    public Product(){

    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String descr;
    private String brand;
    private BigDecimal price;
    private String category;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")//{Handled in frontend}
    private Date releaseDate;
    private Boolean available;
    private Integer quantity;

    private String imageName;
    private String imageType;
    @Lob
    @Column(name = "image_data")
    @JsonIgnore
    @Basic(fetch = FetchType.LAZY)
    private byte[] imageData;

    public Product(Integer id, String name, String descr, String brand, BigDecimal price, String category, Date releaseDate, Boolean available, Integer quantity, String imageName, String imageType, byte[] imageData) {
        this.id = id;
        this.name = name;
        this.descr = descr;
        this.brand = brand;
        this.price = price;
        this.category = category;
        this.releaseDate = releaseDate;
        this.available = available;
        this.quantity = quantity;
        this.imageName = imageName;
        this.imageType = imageType;
        this.imageData = imageData;
    }
}
