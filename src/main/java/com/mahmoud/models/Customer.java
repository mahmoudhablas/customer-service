package com.mahmoud.models;


import io.micronaut.core.annotation.Introspected;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Introspected
@Data
@ToString
public class Customer {
    private String name;
    private String id;
    private String email;
}
