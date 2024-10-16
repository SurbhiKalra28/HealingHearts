package com.surbhikalra.healinghearts.repository;

import com.surbhikalra.healinghearts.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
