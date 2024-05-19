package com.metaverso.metaverso_java.domain.repositories;

import com.metaverso.metaverso_java.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = "select p from product p where p.price between :min and :max")
public List<Product>selecBetweenPrice(BigDecimal min, BigDecimal max);
}
