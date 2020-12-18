package com.rentbook.api.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentbook.api.models.Rent;
import com.rentbook.api.models.RentDTO;
import com.rentbook.api.services.RentService;

@RestController
@RequestMapping("/rents")
public class RentResource {

	@Autowired
	private RentService service;

	@GetMapping
	public ResponseEntity<?> listAll() {
		List<Rent> list = service.findAll();
		List<Rent> response = service.calcRentValues(list);
		return !response.isEmpty() ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
	}

	@GetMapping("/lastrents")
	public ResponseEntity<?> listLastRents() {
		List<Rent> list = service.findLastRents();
		return !list.isEmpty() ? ResponseEntity.ok(list) : ResponseEntity.noContent().build();
	}

	@GetMapping("/nextdevolutions")
	public ResponseEntity<?> listNextDevolutions() {
		List<Rent> list = service.findNextDevolutions();
		return !list.isEmpty() ? ResponseEntity.ok(list) : ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Rent> findOne(@PathVariable Long id) {
		Rent response = service.findById(id);
		return ResponseEntity.ok(response);
	}

	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Rent obj) {
		Rent save = service.createRent(obj);
		return save != null ? ResponseEntity.status(HttpStatus.CREATED).body(save)
				: ResponseEntity.badRequest().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Rent obj) {
		Rent updated = service.devolutionBook(id, obj);
		return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
	}

}
