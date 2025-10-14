package com.mahmoud.models;


import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Introspected
@Data
@ToString
@Serdeable
public class Customer {
    private String name;
    @Nullable
    private Long id;
    private String email;
}
