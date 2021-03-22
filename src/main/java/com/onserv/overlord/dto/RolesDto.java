package com.onserv.overlord.dto;

import lombok.Builder;
 
@Builder
public class RolesDto {

    private Long id; // will be set when persisting

    private String role_name;

}