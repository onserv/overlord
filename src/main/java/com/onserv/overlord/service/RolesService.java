package com.onserv.overlord.service;

import com.onserv.overlord.entity.Roles;
import com.onserv.overlord.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service 
public class RolesService implements RolesRepository {

    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public <S extends Roles> S save(S entity) {
        return rolesRepository.save(entity);
    }

    @Override
    public <S extends Roles> Iterable<S> saveAll(Iterable<S> entities) {
        return rolesRepository.saveAll(entities);
    }

    @Override
    public Optional<Roles> findById(Long id) {
        return rolesRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return rolesRepository.existsById(id);
    }

    @Override
    public Iterable<Roles> findAll() {
        return rolesRepository.findAll();
    }

    @Override
    public Iterable<Roles> findAllById(Iterable<Long> ids) {
        return rolesRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return rolesRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        rolesRepository.deleteById(id);
    }

    @Override
    public void delete(Roles entity) {
        rolesRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        rolesRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAll(Iterable<? extends Roles> entities) {
        rolesRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        rolesRepository.deleteAll();
    }

}
