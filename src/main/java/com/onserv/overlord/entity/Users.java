package com.onserv.overlord.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id; // will be set when persisting

    String first_name;
    String last_name;
    String username;
    String password;
    String email;
    String phone_number;
    Boolean is_active;

    Long role_id;

}