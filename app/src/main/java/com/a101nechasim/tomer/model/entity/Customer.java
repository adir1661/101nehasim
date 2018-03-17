package com.a101nechasim.tomer.model.entity;

/**
 * Created by Adir on 2/19/2018.
 */

public abstract class Customer {
    protected long id;
    protected String name;
    protected String cellphone;
    protected String email;

    public Customer(String name, String cellphone, String email) {

        this.name = name;
        this.cellphone = cellphone;
        this.email = email;
    }

    public Customer() {
        id = 0;
    }

    public Customer(Customer other) {
        this.id = other.id;
        this.name = other.name;
        this.cellphone = other.cellphone;
        this.email = other.email;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
