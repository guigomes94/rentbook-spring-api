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

import com.rentbook.api.models.Author;
import com.rentbook.api.services.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorResource {
	
	@Autowired
	private AuthorService service;
	
	@GetMapping
	public ResponseEntity<?> listAll() {
		List<Author> response = service.findAll();
		return !response.isEmpty() ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Author> findOne(@PathVariable Long id) {
		Author response = service.findById(id);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Author obj) {
		Author save = service.createAuthor(obj);
		return save != null ? ResponseEntity.status(HttpStatus.CREATED).body(save) : ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody Author obj) {
		Author updated = service.updateAuthor(id, obj);
		return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
	}

}
