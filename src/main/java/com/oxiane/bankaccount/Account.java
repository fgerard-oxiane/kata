package com.oxiane.bankaccount;

import exception.InvalidOperation;

import java.math.BigDecimal;

public class Account {

    private BigDecimal balance;

    public Account(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal deposit) throws InvalidOperation {
        if(deposit == null) {
            throw new InvalidOperation("The deposit can not be null !");
        }
        if(deposit.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidOperation("The deposit can not be negative !");
        }
        balance = balance.add(deposit);
    }

}
