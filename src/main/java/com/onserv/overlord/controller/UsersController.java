package com.onserv.overlord.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.onserv.overlord.dto.UserDto;
import com.onserv.overlord.entity.Users;
import com.onserv.overlord.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

    @Autowired
    private UsersService service;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<UserDto>> findAllUsers() {
        List<UserDto> dto = StreamSupport.stream(service.findAll().spliterator(), false)
        .map(user -> 
            UserDto.builder()
            .id(user.getId())
            .first_name(user.getFirst_name() )
            .last_name(user.getLast_name())
            .username(user.getUsername())
            .email(user.getEmail())
            .phone_number(user.getPhone_number())
            .is_active(user.getIs_active())
            .role_id(user.getRole_id())
            .build())
        .collect(Collectors.toList());

        return dto != null ? ResponseEntity.ok(dto): ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> findUsersById(@PathVariable("id") Long id) {
           return service.findById(id).map(user -> 
           ResponseEntity.ok(UserDto.builder()
            .id(user.getId())
            .first_name(user.getFirst_name() )
            .last_name(user.getLast_name())
            .username(user.getUsername())
            .email(user.getEmail())
            .phone_number(user.getPhone_number())
            .is_active(user.getIs_active())
            .role_id(user.getRole_id())
            .build())).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Users create(@RequestBody UserDto request) {
            return service.save(Users.builder()
            .first_name(request.getFirst_name())
            .last_name(request.getLast_name())
            .username(request.getUsername())
            .email(request.getEmail())
            .phone_number(request.getPhone_number())
            .is_active(request.getIs_active())
            .role_id(request.getRole_id())
            .build());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody UserDto request) {
        service.save(Users.builder().id(request.getId())
        .first_name(request.getFirst_name())
        .last_name(request.getLast_name())
        .username(request.getUsername())
        .email(request.getEmail())
        .phone_number(request.getPhone_number())
        .is_active(request.getIs_active())
        .role_id(request.getRole_id())
        .build());
    }
}