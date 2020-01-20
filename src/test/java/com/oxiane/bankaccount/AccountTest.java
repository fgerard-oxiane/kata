package com.oxiane.bankaccount;

import com.oxiane.bankaccount.exception.InvalidOperation;
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

    @Test(expected = InvalidOperation.class)
    public void shouldThrowsExceptionForNegativeBalance() throws InvalidOperation {
        Account clientAccount = new Account(BigDecimal.ONE);
        clientAccount.withdrawal(BigDecimal.TEN);
    }

    @Test
    public void shouldNotThrowsExceptionForZeroBalance() throws InvalidOperation {
        Account clientAccount = new Account(BigDecimal.TEN);
        try{
            clientAccount.withdrawal(BigDecimal.TEN);
        } catch (InvalidOperation ex){
            fail();
        }
    }

    @Test(expected = InvalidOperation.class)
    public void shouldReturnBalanceMinusWithdrawalAmount() throws InvalidOperation {
        Account clientAccount = new Account(BigDecimal.ONE);
        clientAccount.withdrawal(BigDecimal.TEN);
        assertTrue(clientAccount.getBalance().equals(BigDecimal.valueOf(9)));
    }

}