package com.oxiane.bankaccount;

import java.math.BigDecimal;
import java.util.Date;

public class OperationHistory {

    private Operation operation;
    private Date date;
    private BigDecimal amount;
    private BigDecimal balance;

    public OperationHistory(Operation operation, BigDecimal amount, BigDecimal balance) {
        this.operation = operation;
        this.date = new Date();
        this.amount = amount;
        this.balance = balance;
    }

    public Operation getOperation() {
        return operation;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
