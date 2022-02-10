package com.devcoder.application.resolver.query;

import com.devcoder.application.model.BankAccount;
import com.devcoder.application.model.Client;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

    public static List<BankAccount> demoAccounts = Stream.of(
            new BankAccount(UUID.randomUUID(), new Client(UUID.randomUUID(), "John", "Snow")),
            new BankAccount(UUID.randomUUID(), new Client(UUID.randomUUID(), "Arya", "Stark")),
            new BankAccount(UUID.randomUUID(), new Client(UUID.randomUUID(), "Rob", "Stark")),
            new BankAccount(UUID.randomUUID(), new Client(UUID.randomUUID(), "Daenerys", "Targaryen"))
    ).collect(Collectors.toList());

    public List<BankAccount> accounts(){
        log.debug("Fetching all bank accounts");
        return demoAccounts;
    }

    public Optional<BankAccount> account(UUID id){
        log.debug("Fetching bank account: {}", id);
        return demoAccounts.stream().filter(bankAccount -> bankAccount.getId().equals(id)).findFirst();
    }
}
