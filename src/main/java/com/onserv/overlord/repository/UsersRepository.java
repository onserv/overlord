package com.onserv.overlord.repository;

import com.onserv.overlord.entity.Users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface UsersRepository extends CrudRepository<Users, Long> {

}
