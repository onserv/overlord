package com.onserv.overlord.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import com.onserv.overlord.dto.RolesDto;
import com.onserv.overlord.entity.Roles;
import com.onserv.overlord.service.RolesService;
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
@RequestMapping("/roles")
@AllArgsConstructor
public class RolesController {

    @Autowired
    private RolesService service;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<RolesDto>> findAllRoles() {
        List<RolesDto> dto = StreamSupport.stream(service.findAll().spliterator(), false)
        .map(role -> 
            RolesDto.builder()
            .id(role.getId())
            .role_name(role.getRole_name())
            .build())
        .collect(Collectors.toList());

        return dto != null ? ResponseEntity.ok(dto): ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RolesDto> findRolesById(@PathVariable("id") Long id) {
           return service.findById(id).map(role ->
           ResponseEntity.ok(RolesDto.builder()
            .id(role.getId())
            .role_name(role.getRole_name())
            .build())).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Roles create(@RequestBody RolesDto request) {
        return service.save(Roles.builder()
        .role_name(request.getRole_name())
        .build());
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody RolesDto request) {
        service.save(Roles.builder().id(request.getId())
        .role_name(request.getRole_name())
        .build());
    }


}