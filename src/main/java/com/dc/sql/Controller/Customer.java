package com.dc.sql.Controller;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Customer {
    //@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // getters and Account...
    public String account;

    protected Customer() {
    }

    public Customer(String Account) {
        this.account =Account;
    }

    public void getAccount(String Account) {
        this.account =Account;
    }

    public void setAccount(String Account) {
        this.account =Account;
    }




}
