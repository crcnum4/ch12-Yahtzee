package com.abstraction.accounts;

public class CheckingAccount extends BankAccount {
    private int fee = 2;

    public CheckingAccount(String id, long balance, String name, String pin) {
        super(id, balance, name, pin);
    }

    private void setBalance(int amt) {
        if (amt < 0) {
           this.balance += amt;
        }
    }

}
