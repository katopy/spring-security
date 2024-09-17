package com.spring_security.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveCategory implements Serializable {

    @NotBlank
    private String name;

    @Min(value = 1)
    private Long categoryId;


}
