package com.spring_security.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveUser implements Serializable {

    @Size(min = 4)
    private String name;
    @Size(min = 4)
    private String username;
    @Size(min = 8)
    private String password;
    @Size(min = 8)
    private String repeatedPassword;
}
