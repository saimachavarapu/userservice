package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bean.user;

public interface UserRepository extends JpaRepository<user,Long> {
	Optional<user> findByUsername(String address);



}
