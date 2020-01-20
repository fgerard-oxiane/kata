package com.oxiane.bankaccount;

import com.oxiane.bankaccount.exception.InvalidOperation;
import com.oxiane.bankaccount.validation.AccountOperationValidator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private BigDecimal balance;
    private List<OperationHistory> operations;

    private AccountOperationValidator validator;

    private Account() {
        this.validator = new AccountOperationValidator();
        this.operations = new ArrayList<>();
    }

    public Account(BigDecimal balance) {
        this();
        this.balance = balance;
        operations.add(new OperationHistory(Operation.DEPOSIT, balance, balance));
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<OperationHistory> getOperations() {
        return operations;
    }

    public void deposit(BigDecimal deposit) throws InvalidOperation {
        this.validator.depositOperationValidation(deposit);
        balance = balance.add(deposit);
        operations.add(new OperationHistory(Operation.DEPOSIT, deposit, balance));
    }

    public void withdrawal(BigDecimal withdrawal) throws InvalidOperation {
        this.validator.withdrawalOperationValidation(withdrawal, this.balance);
        balance = balance.subtract(withdrawal);
        operations.add(new OperationHistory(Operation.WITHDRAWAL, withdrawal, balance));
    }

}
