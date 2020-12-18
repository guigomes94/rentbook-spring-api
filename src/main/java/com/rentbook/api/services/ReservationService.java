package com.rentbook.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentbook.api.models.Reservation;
import com.rentbook.api.repositories.ReservationRepository;
import com.rentbook.api.services.exceptions.EntityNotFoundException;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository repository;
	
	public List<Reservation> findAll() {
		return repository.findAll();
	}
	
	public Reservation findById(Long id) {
		return repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Scheduling not found! ID " + id + " not exist."));
	}
	
	public Reservation createReservation(Reservation obj) {
		try {
			return repository.save(obj);
			
		} catch (IllegalArgumentException e) {
			return null;
			
		}
	}
	
	public Reservation updateReservation(Long id, Reservation obj) {
		Optional<Reservation> oldObj = repository.findById(id);
		
		if (oldObj.isPresent()) {
			Reservation updated = oldObj.get();
			updated.setBook(obj.getBook());
			updated.setUser(obj.getUser());
			updated.setRentDate(obj.getRentDate());
			
			return repository.save(updated);
		}
		
		return null;
	}
	
	public void cancelReservation(Long id) {
		repository.deleteById(id);
	}
}
