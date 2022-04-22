package com.spring.sigmaweb.backend.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Mail {
    private String from;
    private String to;
    private String subject;
    private String message;
//    private Map<String, Object> model;
}
