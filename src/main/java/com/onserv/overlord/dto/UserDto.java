package com.onserv.overlord.dto;

import lombok.Builder;
 
@Builder
public class UserDto {

    private Long id; // will be set when persisting

    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String phone_number;

    private Boolean is_active;

    private Integer role_id;

}