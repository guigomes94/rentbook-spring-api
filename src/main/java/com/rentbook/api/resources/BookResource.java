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

import com.rentbook.api.models.Book;
import com.rentbook.api.services.BookService;

@RestController
@RequestMapping("/books")
public class BookResource {
	
	@Autowired
	private BookService service;
	
	@GetMapping
	public ResponseEntity<?> listAll() {
		List<Book> response = service.findAll();
		return !response.isEmpty() ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/availables")
	public ResponseEntity<?> listAvailables() {
		List<Book> response = service.findAvailables();
		return !response.isEmpty() ? ResponseEntity.ok(response) : ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> findOne(@PathVariable Long id) {
		Book response = service.findById(id);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Book obj) {
		Book save = service.createBook(obj);
		return save != null ? ResponseEntity.status(HttpStatus.CREATED).body(save) : ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updated(@PathVariable Long id, @Valid @RequestBody Book obj) {
		Book updated = service.updateBook(id, obj);
		return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
	}

}
