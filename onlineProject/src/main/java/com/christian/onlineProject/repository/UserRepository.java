package com.christian.onlineProject.repository;

import com.christian.onlineProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
