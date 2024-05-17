package com.metaverso.metaverso_java.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.metaverso.metaverso_java.domain.entities.User;

public interface UserRepository  extends JpaRepository<User, Long>{

    @Query(value = "select u from user u where u.email between : min and :max")
    public List<User> selectBetweenEmail(String min, String max);
}
