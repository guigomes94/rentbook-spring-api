package com.rentbook.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentbook.api.models.Rent;

public interface RentRepository extends JpaRepository<Rent, Long>{

}
