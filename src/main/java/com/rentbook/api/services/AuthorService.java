package com.rentbook.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentbook.api.models.Author;
import com.rentbook.api.repositories.AuthorRepository;
import com.rentbook.api.services.exceptions.EntityNotFoundException;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository repository;
	
	public List<Author> findAll() {
		return repository.findAll();
	}
	
	public Author findById(Long id) {
		return repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Author not found! ID " + id + " not exist."));
	}
	
	public Author createAuthor(Author obj) {
		try {
			return repository.save(obj);
			
		} catch (IllegalArgumentException e) {
			return null;
			
		}
	}
	
	public Author updateAuthor(Long id, Author obj) {
		Optional<Author> oldObj = repository.findById(id);
		
		if (oldObj.isPresent()) {
			Author updated = oldObj.get();
			updated.setName(obj.getName());
			
			return repository.save(updated);
		}
		
		return null;
	}
}
