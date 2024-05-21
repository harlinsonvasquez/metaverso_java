package com.metaverso.metaverso_java.domain.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metaverso.metaverso_java.domain.entities.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Long>{
    
    //@Query (value = "select p from purchase p join fetch p. user p wherw p.id=:idUser")
    Optional<Purchase> findById (Long idUser);
    //List<Purchase> findByUserId(Long userId);

    //@EntityGraph(attributePaths = {"products"})
    List<Purchase> findByUserId(Long userId);

}
