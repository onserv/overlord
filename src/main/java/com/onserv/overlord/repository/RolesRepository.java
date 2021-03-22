package com.onserv.overlord.repository;

import com.onserv.overlord.entity.Roles;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface RolesRepository extends CrudRepository<Roles, Long> {

}
