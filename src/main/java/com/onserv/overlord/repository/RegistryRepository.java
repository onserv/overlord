package com.onserv.overlord.repository;

import com.onserv.overlord.entity.Registry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface RegistryRepository extends CrudRepository<Registry, Long> {

}
