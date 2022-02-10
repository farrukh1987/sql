package com.dc.sql.database;

import javax.persistence.*;

@Entity
@Table(name = "oper")

public class Customer implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // getters and oper...
    private String payid;
    private String term;
    private String code;

    public Customer(String payid,String term,String code) {
        this.payid = payid;
        this.term = term;
        this.code = code;
    }

    public void getPayId() {
        this.payid =payid;
    }

    public void setPayId(String payid) {
        this.payid =payid;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    protected Customer() {
    }


    @Override
    public String toString() {
        return "Customer [id=" + payid +  ",term="+term+",code="+code+"]";
    }


    /*public Iterable<Object> values() {
    }*/
}
