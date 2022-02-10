package com.devcoder.application.resolver.mutation;

import com.devcoder.application.dto.AccountCreateInput;
import com.devcoder.application.model.BankAccount;
import com.devcoder.application.model.Client;
import com.devcoder.application.resolver.query.BankAccountResolver;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class BankAccountMutationResolver implements GraphQLMutationResolver {

    public BankAccount createAccount(AccountCreateInput data){
        log.debug("Creating account for user : {}");
        BankAccount bankAccount = BankAccount.builder()
                                             .id(UUID.randomUUID())
                                             .client(Client.builder()
                                                     .id(UUID.randomUUID())
                                                     .firstName(data.getFirstName())
                                                     .lastName(data.getLastName())
                                                     .build()
                                             ).build();

        BankAccountResolver.demoAccounts.add(bankAccount);
        return bankAccount;
    }
}
