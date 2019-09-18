package com.slabiak.xloads.repository;

import com.slabiak.xloads.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
