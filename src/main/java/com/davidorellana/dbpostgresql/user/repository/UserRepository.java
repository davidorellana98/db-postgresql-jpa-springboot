package com.davidorellana.dbpostgresql.user.repository;

import com.davidorellana.dbpostgresql.user.model.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { }
