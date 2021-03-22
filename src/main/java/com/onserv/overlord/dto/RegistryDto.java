package com.onserv.overlord.dto;

import lombok.Builder;

@Builder
public class RegistryDto {

    private Long id; // will be set when persisting

    private String client_id;
    private String secret;
    private Boolean is_active;
    private String scopes;
    // private String created_date;
    // private String modified_date;

}