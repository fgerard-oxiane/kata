package com.oxiane.bankaccount.validation;

import com.oxiane.bankaccount.Account;
import com.oxiane.bankaccount.exception.InvalidOperation;

import java.math.BigDecimal;

public class AccountOperationValidator {

    public static void depositOperationValidation(BigDecimal deposit) throws InvalidOperation {
        nullOrNegativeAmountValidation("deposit", deposit);
    }

    public static void withdrawalOperationValidation(BigDecimal deposit, BigDecimal balance) throws InvalidOperation {
        nullOrNegativeAmountValidation("withdrawal", deposit);
        negativeBalanceValidation(deposit, balance);
    }

    private static void nullOrNegativeAmountValidation(String operation, BigDecimal amount) throws InvalidOperation {
        if(amount == null) {
            throw new InvalidOperation(String.format("The %s can not be null !", operation));
        }
        if(amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidOperation(String.format("The %s can not be negative !", operation));
        }
    }

    private static void negativeBalanceValidation(BigDecimal deposit, BigDecimal balance) throws InvalidOperation {
        if(balance.subtract(deposit).compareTo(BigDecimal.ZERO) < 0){
            throw new InvalidOperation("The balance can not be negative !");
        }
    }

}
