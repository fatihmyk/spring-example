package com.fatihmayuk.pagination.repository;

import com.fatihmayuk.pagination.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {



}
