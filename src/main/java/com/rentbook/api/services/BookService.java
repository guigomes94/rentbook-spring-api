package com.rentbook.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentbook.api.models.Book;
import com.rentbook.api.repositories.BookRepository;
import com.rentbook.api.services.exceptions.EntityNotFoundException;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	public List<Book> findAll() {
		return repository.findAll();
	}
	
	public Book findById(Long id) {
		return repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Book not found! ID " + id + " not exist."));
	}
	
	public List<Book> findAvailables() {
		return repository.listBooksAvailables();
	}

	public Book createBook(Book obj) {
		try {
			return repository.save(obj);

		} catch (IllegalArgumentException e) {
			return null;

		}
	}

	public Book updateBook(Long id, Book obj) {
		Optional<Book> oldObj = repository.findById(id);

		if (oldObj.isPresent()) {
			Book updated = oldObj.get();
			updated.setTitle(obj.getTitle());
			updated.setAuthor(obj.getAuthor());
			updated.setAvailable(obj.getAvailable());

			return repository.save(updated);
		}

		return null;
	}
	
	public Book changeAvailability(Long id) {
		Optional<Book> book = repository.findById(id);
		
		if (book.isPresent()) {
			Book updated = book.get();
			updated.setAvailable(!updated.getAvailable());

			return repository.save(updated);
		}
		return null;
	}
	
}
