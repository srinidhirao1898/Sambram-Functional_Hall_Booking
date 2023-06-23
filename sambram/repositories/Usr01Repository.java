package com.webapp.sambram.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.sambram.Entities.Usr01;

public interface Usr01Repository extends JpaRepository<Usr01, String>{
	Optional<Usr01> findByEmail(String email);
    Boolean existsByEmail(String email);
}
