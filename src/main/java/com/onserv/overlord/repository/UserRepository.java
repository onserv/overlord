package com.onserv.overlord.repository;

import com.onserv.overlord.entity.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
