package com.projectdl.recantogeek.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;
    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    private List<ProductModel> productModels = new ArrayList<>();

    public CategoryModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CategoryModel categoryModel = (CategoryModel) o;
        return id != null && Objects.equals(id, categoryModel.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}