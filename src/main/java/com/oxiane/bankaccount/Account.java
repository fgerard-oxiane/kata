package com.oxiane.bankaccount;

import com.oxiane.bankaccount.exception.InvalidOperation;
import com.oxiane.bankaccount.validation.AccountOperationValidator;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance;
    private AccountOperationValidator validator;

    private Account() {
        this.validator = new AccountOperationValidator();
    }

    public Account(BigDecimal balance) {
        this();
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal deposit) throws InvalidOperation {
        this.validator.depositOperationValidation(deposit);
        balance = balance.add(deposit);
    }

    public void withdrawal(BigDecimal withdrawal) throws InvalidOperation {
        this.validator.withdrawalOperationValidation(withdrawal, this.balance);
        balance = balance.subtract(withdrawal);
    }

}
