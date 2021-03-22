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
public class Roles {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id; // will be set when persisting

    String role_name;

}