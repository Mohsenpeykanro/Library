package com.library.backend.Repository;

import com.library.backend.Entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<userEntity, Integer> {

    @Query("select s from userEntity s where s.email = ?1")
    Optional<userEntity> finduserEntityByEmail(String email);
}
