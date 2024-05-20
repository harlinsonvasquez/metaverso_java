package com.metaverso.metaverso_java.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.metaverso.metaverso_java.domain.entities.User;

public interface UserRepository  extends JpaRepository<User, Long>{

        @Query("SELECT u FROM User u WHERE u.name = :name")
    List<User> findByName(@Param("name") String name);
}
