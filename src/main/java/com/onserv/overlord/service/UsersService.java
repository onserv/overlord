package com.onserv.overlord.service;

import java.util.Optional;

import com.onserv.overlord.entity.Users;
import com.onserv.overlord.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class UsersService implements UsersRepository{
    @Autowired
    private UsersRepository userRepository;

    @Override
    public <S extends Users> S save(S entity) {
        return userRepository.save(entity);
    }

    @Override
    public <S extends Users> Iterable<S> saveAll(Iterable<S> entities) {
        return userRepository.saveAll(entities);
    }

    @Override
    public Optional<Users> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public Iterable<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Iterable<Users> findAllById(Iterable<Long> ids) {
        return userRepository.findAllById(ids);
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void delete(Users entity) {
        userRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        userRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAll(Iterable<? extends Users> entities) {
        userRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

}
