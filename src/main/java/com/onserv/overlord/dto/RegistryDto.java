package com.onserv.overlord.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RegistryDto {

    private Long id; // will be set when persisting

    private String client_id;
    private String secret;
    private Boolean is_active;
    private String scopes;
    // private String created_date;
    // private String modified_date;

}