package com.library.backend.Repository;

import com.library.backend.Entity.bookEntity;
import com.library.backend.Entity.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface bookRepository extends JpaRepository<bookEntity, Integer> {

    @Query("select s from bookEntity s where s.name = ?1")
    Optional<bookEntity> findbookEntityByname(String name);
}
