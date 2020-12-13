package com.rentbook.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentbook.api.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
