package com.onserv.overlord.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Registry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id; // will be set when persisting

    String client_id;
    String secret;
    Boolean is_active;
    String scopes;
    // private String created_date;
    // private String modified_date;

}