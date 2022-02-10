package com.devcoder.application.model;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccount {
    private UUID id;
    private Client client;
}
