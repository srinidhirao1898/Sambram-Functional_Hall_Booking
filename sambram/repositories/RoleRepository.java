package com.webapp.sambram.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.sambram.Entities.Role;

public interface RoleRepository extends JpaRepository<Role, String	> {
    Optional<Role> findByName(String name);
}
