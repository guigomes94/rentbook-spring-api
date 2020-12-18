package com.rentbook.api.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rentbook.api.models.Rent;

public interface RentRepository extends JpaRepository<Rent, Long> {
	
	@Query("SELECT r FROM Rent r WHERE r.rentDate <= ?1 and r.rentDate >= ?2")
	public List<Rent> listLastRents(LocalDate today, LocalDate behind);
	
	@Query("SELECT r FROM Rent r WHERE r.devolutionDate <= ?1 and r.devolutionDate >= ?2")
	public List<Rent> listNextDevolutions(LocalDate after, LocalDate today);

}
