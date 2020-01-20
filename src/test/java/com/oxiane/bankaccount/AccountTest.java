package com.oxiane.bankaccount;

import exception.InvalidOperation;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AccountTest {

    @Test(expected = InvalidOperation.class)
    public void shouldThrowsExceptionForNullOrNegativeDepositAmount() throws InvalidOperation {
        Account clientAccount = new Account(BigDecimal.TEN);
        clientAccount.deposit(null);
        clientAccount.deposit(BigDecimal.valueOf(-10));
    }

    @Test
    public void shouldReturnBalancePlusDepositAmount() throws InvalidOperation {
        Account clientAccount = new Account(BigDecimal.TEN);
        clientAccount.deposit(BigDecimal.TEN);
        assertTrue(clientAccount.getBalance().equals(BigDecimal.valueOf(20)));
    }

    @Test(expected = InvalidOperation.class)
    public void shouldThrowsExceptionForNullOrNegativeWithdrawalAmount() throws InvalidOperation {
        Account clientAccount = new Account(BigDecimal.TEN);
        clientAccount.withdrawal(null);
        clientAccount.withdrawal(BigDecimal.valueOf(-10));
    }

    @Test
    public void shouldReturnBalanceMinusWithdrawalAmount() throws InvalidOperation {
        Account clientAccount = new Account(BigDecimal.TEN);
        clientAccount.withdrawal(BigDecimal.ONE);
        assertTrue(clientAccount.getBalance().equals(BigDecimal.valueOf(9)));
    }

}