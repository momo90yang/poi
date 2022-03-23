package com.yxd.dto;

public class People {
    String name;
    int age;
    String accountType;

    public People(String name, int age, String accountType) {
        this.name = name;
        this.age = age;
        this.accountType = accountType;
    }

    public People() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

}
