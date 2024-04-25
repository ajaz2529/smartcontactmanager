package com.smart.repository;

import com.smart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByNameAndPassword(String name, String password);
    public User findByEmail(String Email);
}
