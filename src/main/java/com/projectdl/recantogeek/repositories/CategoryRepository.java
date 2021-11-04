package com.projectdl.recantogeek.repositories;

import com.projectdl.recantogeek.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryRepository, Long> {
}