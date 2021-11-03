package com.library.backend.Repository;

import com.library.backend.Entity.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface bookRepository extends JpaRepository<book, Integer> {

    @Query("select s from book s where s.name = ?1")
    Optional<book> findbookEntityByname(String name);
}
