package com.onserv.overlord.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.onserv.overlord.dto.UserDto;
import com.onserv.overlord.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        return dto != null ? ResponseEntity.ok(dto): null;
    }

    

    @GetMapping(value = "/{id}")
    public UserDto findUsersById(@PathVariable("id") Long id) {
           return service.findById(id).map(user -> 
            UserDto.builder()
            .id(user.getId())
            .first_name(user.getFirst_name() )
            .last_name(user.getLast_name())
            .username(user.getUsername())
            .email(user.getEmail())
            .phone_number(user.getPhone_number())
            .is_active(user.getIs_active())
            .role_id(user.getRole_id())
            .build()
            ).orElse(null);
    }

   /* 
    @PostMapping
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

    @PatchMapping("/patch")
    public @ResponseBody ResponseEntity<String> patch() {
        return new ResponseEntity<String>("PATCH Response", HttpStatus.OK);
    }
*/
}