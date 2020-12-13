package com.rentbook.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentbook.api.models.User;
import com.rentbook.api.repositories.UserRepository;
import com.rentbook.api.services.exceptions.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		return repository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("User not found! ID " + id + " not exist."));
	}

	public User createUser(User obj) {
		try {
			return repository.save(obj);

		} catch (IllegalArgumentException e) {
			return null;

		}
	}

	public User updateUser(Long id, User obj) {
		Optional<User> oldObj = repository.findById(id);

		if (oldObj.isPresent()) {
			User updated = oldObj.get();
			updated.setName(obj.getName());
			updated.setAvatar(obj.getAvatar());
			updated.setEmail(obj.getEmail());
			updated.setPhone(obj.getPhone());

			return repository.save(updated);
		}

		return null;
	}

}
