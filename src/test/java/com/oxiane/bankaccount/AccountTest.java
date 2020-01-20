package com.oxiane.bankaccount;

import exception.InvalidOperation;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AccountTest {

    @Test(expected = InvalidOperation.class)
    public void shouldThrowsExceptionForNullOrNegativeAmount() throws InvalidOperation {
        Account clientAccount = new Account(BigDecimal.TEN);
        clientAccount.deposit(null);
        clientAccount.deposit(BigDecimal.valueOf(-10));
    }

    @Test
    public void shouldReturnBalancePlusAmount() throws InvalidOperation {
        Account clientAccount = new Account(BigDecimal.TEN);
        clientAccount.deposit(BigDecimal.TEN);
        assertTrue(clientAccount.getBalance().equals(BigDecimal.valueOf(20)));
    }

}