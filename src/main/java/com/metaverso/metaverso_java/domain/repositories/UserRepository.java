package com.metaverso.metaverso_java.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metaverso.metaverso_java.domain.entities.User;

public interface UserRepository  extends JpaRepository<User, Long>{

    @Query("SELECT u FROM user u " +
            "LEFT JOIN FETCH u.subscription " +
            "LEFT JOIN FETCH u.purchases p " +
            "LEFT JOIN FETCH p.purchaseProducts pp " +
            "LEFT JOIN FETCH pp.product " +
            "WHERE u.id = :id")
    User findUserWithPurchasesAndProducts(@Param("id") Long id);

}
