package com.spring_security.config.security;

import org.springframework.data.web.config.EnableSpringDataWebSupport;
@org.springframework.context.annotation.Configuration

@EnableSpringDataWebSupport(
        pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO
)
public class Configuration {
}