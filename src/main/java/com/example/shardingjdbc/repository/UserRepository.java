package com.example.shardingjdbc.repository;

import com.example.shardingjdbc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wenbo Huang
 * @version 1.0
 * @date 2021/1/12 4:30 PM
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
