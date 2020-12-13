package com.rentbook.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentbook.api.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
