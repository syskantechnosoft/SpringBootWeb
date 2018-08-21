package com.uhg.webboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uhg.webboot.bean.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
