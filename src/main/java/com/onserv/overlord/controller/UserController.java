package com.onserv.overlord.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.onserv.overlord.dto.UserDto;
import com.onserv.overlord.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<UserDto> findAll() {
        return  StreamSupport.stream(service.findAll().spliterator(), false)
        .map(user -> 
            UserDto.builder()
            .first_name(user.getFirst_name() )
            .last_name(user.getLast_name())
            .email(user.getEmail())
            .is_active(user.getIs_active())
            .build())
        .collect(Collectors.toList());
    }

    @GetMapping(value = "/{id}")
    public UserDto findById(@PathVariable("id") Long id) {
           return service.findById(id).map(user -> 
            UserDto.builder()
            .first_name(user.getFirst_name() )
            .last_name(user.getLast_name())
            .email(user.getEmail())
            .is_active(user.getIs_active())
            .build()).orElse(null);
    }

   /* @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long create(@RequestBody User resource) {
        //Preconditions.checkNotNull(resource);
        return service.create(resource);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @RequestBody User resource) {
        //Preconditions.checkNotNull(resource);
        RestPreconditions.checkNotNull(service.getById(resource.getId()));
        service.update(resource);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
*/
}