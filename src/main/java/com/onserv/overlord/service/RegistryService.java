package com.onserv.overlord.service;

import com.onserv.overlord.entity.Registry;
import com.onserv.overlord.repository.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service 
public class RegistryService implements RegistryRepository {

    @Autowired
    private RegistryRepository registryRepository;

    @Override
    public <S extends Registry> S save(S entity) {
        return registryRepository.save(entity);
    }

    @Override
    public <S extends Registry> Iterable<S> saveAll(Iterable<S> entities) {
        return registryRepository.saveAll(entities);
    }

    @Override
    public Optional<Registry> findById(Long id) {
        return registryRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return registryRepository.existsById(id);
    }

    @Override
    public Iterable<Registry> findAll() {
        return registryRepository.findAll();
    }

    @Override
    public Iterable<Registry> findAllById(Iterable<Long> ids) {
        return registryRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return registryRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        registryRepository.deleteById(id);
    }

    @Override
    public void delete(Registry entity) {
        registryRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        registryRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAll(Iterable<? extends Registry> entities) {
        registryRepository.deleteAll();
    }

    @Override
    public void deleteAll() {
        registryRepository.deleteAll();
    }
}
