package com.metaverso.metaverso_java.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.metaverso.metaverso_java.domain.entities.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,Long>{
    
    /*@Query (value = "select p from purchase p join fetch p. user p where p.id=:idUser")
    Optional<Purchase> findByPurchaseId (Long idUser);*/

}
