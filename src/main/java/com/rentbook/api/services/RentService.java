package com.rentbook.api.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentbook.api.models.Book;
import com.rentbook.api.models.Rent;
import com.rentbook.api.models.RentDTO;
import com.rentbook.api.repositories.RentRepository;
import com.rentbook.api.services.exceptions.EntityNotFoundException;

@Service
public class RentService {

	@Autowired
	private RentRepository repository;
	
	public List<Rent> findAll() {
		return repository.findAll();
	}
	
	public Rent findById(Long id) {
		return repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Rent not found! ID " + id + " not exist."));
	}

	@Autowired
	private BookService bookService;

	public List<RentDTO> calcPaymentValues(List<Rent> rents) {
		List<RentDTO> calculatedRents = new ArrayList<>();

		for (Rent rent : rents) {
			LocalDate rentDate = rent.getRentDate();
			LocalDate devolutionDate = rent.getDevolutionDate();
			LocalDate today = LocalDate.now();
			Double value = rent.calcRent(rentDate, devolutionDate);
			Double lateFee = 0.0;

			if (devolutionDate.isBefore(today)) {
				value = rent.calcRent(rentDate, today);
				lateFee = rent.calcTicket(value);
			}

			RentDTO response = new RentDTO();
			response.setId(rent.getId());
			response.setUser(rent.getUser().getName());
			response.setBook(rent.getBook().getTitle());
			response.setRentDate(rent.getRentDate());
			response.setDevolutionDate(rent.getDevolutionDate());
			response.setRentValue(value);
			response.setLateFee(lateFee);

			calculatedRents.add(response);
		}
		return calculatedRents;
	}

	public Rent createRent(Rent obj) {

		Book changeAvailability = bookService.changeAvailability(obj.getBook().getId());

		if (changeAvailability != null) {
			try {
				return repository.save(obj);

			} catch (IllegalArgumentException e) {
				return null;

			}
		}
		return null;
	}

	@SuppressWarnings("unused")
	public RentDTO devolutionBook(Long id, Rent obj) { 
		Optional<Rent> oldObj = repository.findById(id);
		Book changeAvailability = bookService.changeAvailability(obj.getBook().getId());
		RentDTO devolution = new RentDTO();
		
		if (oldObj.isPresent()) {
			Rent updated = oldObj.get();
			LocalDate rentDate = updated.getRentDate();
			LocalDate devolutionDate = updated.getDevolutionDate();
			LocalDate today = LocalDate.now();
			Double paymentValue = updated.calcRent(rentDate, devolutionDate);
			Double lateFee = 0.0;
			
			if (devolutionDate.isBefore(today)) {
				devolutionDate = today;
				paymentValue = updated.calcRent(rentDate, devolutionDate);
				lateFee = updated.calcTicket(paymentValue);
			}
			
			updated.setPaymentValue(paymentValue);
			repository.save(updated);
			
			devolution.setId(updated.getId());
			devolution.setUser(updated.getUser().getName());
			devolution.setBook(updated.getBook().getTitle());
			devolution.setRentDate(rentDate);
			devolution.setDevolutionDate(devolutionDate);
			devolution.setRentValue(paymentValue);
			devolution.setLateFee(lateFee);
			
			return devolution;
			
		}
		return null;
	}
}
