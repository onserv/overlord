package com.onserv.overlord.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import com.onserv.overlord.dto.RegistryDto;
import com.onserv.overlord.entity.Registry;
import com.onserv.overlord.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/registry")
@AllArgsConstructor
public class RegistryController {

    @Autowired
    private RegistryService service;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<RegistryDto>> findAllRegistry() {
        List<RegistryDto> dto = StreamSupport.stream(service.findAll().spliterator(), false)
        .map(registry -> 
            RegistryDto.builder()
            .id(registry.getId())
            .client_id(registry.getClient_id())
            .is_active(registry.getIs_active())
            .scopes(registry.getScopes())
            .secret(registry.getSecret())
            .build())
        .collect(Collectors.toList());

        return dto != null ? ResponseEntity.ok(dto): null;
    }

    @GetMapping(value = "/{id}")
    public RegistryDto findRegistryById(@PathVariable("id") Long id) {
            return service.findById(id).map(registry ->
            RegistryDto.builder()
            .id(registry.getId())
            .client_id(registry.getClient_id())
            .is_active(registry.getIs_active())
            .scopes(registry.getScopes())
            .secret(registry.getSecret())
            .build()).orElse(null);
    }

    @PostMapping
 //   @ResponseStatus(HttpStatus.CREATED)
    public Registry create(@RequestBody RegistryDto request) {
            return service.save(Registry.builder()
            .client_id(request.getClient_id())
            .is_active(request.getIs_active())
            .scopes(request.getScopes())
            .secret(request.getSecret())
            .build());
    }
   /* 
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