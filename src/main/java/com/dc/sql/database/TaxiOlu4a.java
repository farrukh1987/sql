package com.dc.sql.database;

import javax.persistence.*;

@Entity
@Table(name = "TaxiOlu4a")

public class TaxiOlu4a implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // getters and setter...
    private int id;
    private String driver_id;
    private String mobile_phone;
    private String home_phone;
    private String name;

    public TaxiOlu4a(String driver_id, String mobile_phone, String home_phone, String name) {
        this.driver_id = driver_id;
        this.mobile_phone = mobile_phone;
        this.home_phone = home_phone;
        this.name = name;
    }

    public void getDriver_id() {
        this.driver_id = driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String term) {
        this.mobile_phone = mobile_phone;
    }

    public String getHome_phone() {
        return home_phone;
    }

    public void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String home_phone) {
        this.name = name;
    }

    protected TaxiOlu4a() {
    }

    @Override
    public String toString() {
        return "Customer [driver_id=" + driver_id + ",mobile_phone=" +
                mobile_phone + ",home_phone=" + home_phone + ",name="+name+"]";
    }

}
