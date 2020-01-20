package com.oxiane.bankaccount;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void shouldReturnBalancePlusAmount(){
        Account clientAccount = new Account(BigDecimal.TEN);
        clientAccount.deposit(BigDecimal.TEN);
        assertTrue(clientAccount.getBalance().equals(BigDecimal.valueOf(20)));
    }

}