package com.oxiane.bankaccount;

import com.oxiane.bankaccount.exception.InvalidOperation;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

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

    @Test
    public void shouldReturnOperationHistoryForAccountCreation() {
        Account clientAccount = new Account(BigDecimal.TEN);
        List<OperationHistory> operations = clientAccount.getOperations();
        assertTrue(operations != null);
        assertTrue(operations.size() == 1);
        OperationHistory initialOperation = clientAccount.getOperations().get(0);
        assertTrue(initialOperation.getDate() != null);
        assertTrue(initialOperation.getOperation().equals(Operation.DEPOSIT));
        assertTrue(initialOperation.getAmount().equals(BigDecimal.TEN));
        assertTrue(initialOperation.getBalance().equals(BigDecimal.TEN));
    }

    @Test
    public void shouldReturnAllOperationHistoryForOneAccount() throws InvalidOperation {
        Account clientAccount = new Account(new BigDecimal(2500));
        clientAccount.withdrawal(new BigDecimal(500));
        clientAccount.withdrawal(new BigDecimal(500));
        clientAccount.withdrawal(new BigDecimal(1000));
        clientAccount.deposit(new BigDecimal(500));
        //First withdrawal operation
        OperationHistory operationHistory = clientAccount.getOperations().get(1);
        assertTrue(operationHistory.getAmount().equals(BigDecimal.valueOf(500)));
        assertTrue(operationHistory.getBalance().equals(BigDecimal.valueOf(2000)));
        //After all operations
        assertTrue(clientAccount.getBalance().equals(new BigDecimal(1000)));
    }

}