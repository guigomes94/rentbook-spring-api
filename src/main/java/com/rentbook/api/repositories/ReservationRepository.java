package com.rentbook.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentbook.api.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
