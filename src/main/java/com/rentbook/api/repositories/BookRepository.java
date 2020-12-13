package com.rentbook.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentbook.api.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
