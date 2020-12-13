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

import com.rentbook.api.models.User;
import com.rentbook.api.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<?> listAll() {
		List<User> response = service.findAll();
		return !response.isEmpty() ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findOne(@PathVariable Long id) {
		User response = service.findById(id);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody User obj) {
		User save = service.createUser(obj);
		return save != null ? ResponseEntity.status(HttpStatus.CREATED).body(save) : ResponseEntity.badRequest().build();
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody User obj) {
		User updated = service.updateUser(id, obj);
		return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
	}
}
