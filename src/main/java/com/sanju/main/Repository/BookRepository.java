package com.sanju.main.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanju.main.Entity.MyBook;

public interface BookRepository extends JpaRepository<MyBook, Integer> {
     Optional<MyBook> findByTitle(String title);
}
