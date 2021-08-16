package com.abstraction.accounts;

public class BankAccount {
    private String id;
    protected long balance;
    public String name;
    public String pin;

    public BankAccount (String id, long balance, String name, String pin) {
        this.id = id;
        this.balance = balance;
        this.name = name;
        this.pin = pin;
    }

    private void setBalance(int amt) {
        balance += amt;
    }

    public String getId() {
        return id;
    }

    public void withdraw(int amt, String code) {
        if(code.equals(pin)) {
            setBalance(Math.abs(amt) * -1);
        }
    }
}
