package com.spring.authproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.authproject.entity.ourUsers;

public interface ourUsersRepo extends JpaRepository<ourUsers, Integer> {
	Optional<ourUsers> findByEmail(String email);

}
