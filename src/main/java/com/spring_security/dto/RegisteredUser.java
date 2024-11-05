package com.spring_security.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredUser implements Serializable {

    private Long id;
    private String username;
    private String name;
    private String role;
    private String jwt;
}
