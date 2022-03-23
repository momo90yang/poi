package com.yxd.dto;

public class account {
    private Long accountId;
    private Integer type;
    private Integer balance;

    public account(Long accountId, Integer type, Integer balance) {
        this.accountId = accountId;
        this.type = type;
        this.balance = balance;
    }

    public account() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "account{" +
                "accountId=" + accountId +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                '}';
    }
}
