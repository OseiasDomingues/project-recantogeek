package com.projectdl.recantogeek.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Table(name = "product_model")
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ProductModel {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @NotBlank
    @Column(name = "description", nullable = false)
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @ToString.Exclude
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private CategoryModel category;

    @NotBlank
    @Column(name = "imageURL", nullable = false)
    private String imageURL;

    @Column(name = "installments")
    private Double installments;


    public Double calcInstallments() {
        if (price.intValue() <= 30) {
            return price.doubleValue() / 7;
        } else {
            return price.doubleValue() / 12;
        }

    }

    public ProductModel(Long id, String name, BigDecimal price, String description, String imageURL, CategoryModel category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageURL = imageURL;
        this.category = category;
        installments = calcInstallments();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductModel that = (ProductModel) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}