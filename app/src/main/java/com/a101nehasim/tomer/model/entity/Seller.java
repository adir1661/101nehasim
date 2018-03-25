package com.a101nehasim.tomer.model.entity;

/**
 * Created by Adir on 2/19/2018.
 */

public class Seller extends Customer  {
    protected House house;
    protected long price;


    public Seller(String name, String cellphone, String email,House house,long value) {
        super(name, cellphone, email);
        this.house = new House(house);
        this.price =value;
    }
    public Seller() {
        house = new House();
        price = 500000;
    }
    //------------------getters_&_setters-------------------------------
    public House getHouse() {
        return house;
    }
    public void setHouse(House house) {
        this.house = house;
    }

    public long getPrice() {
        return price;
    }
    public void setPrice(long price) {
        this.price = price;
    }


}
