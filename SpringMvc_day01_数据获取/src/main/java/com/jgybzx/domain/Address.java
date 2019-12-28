package com.jgybzx.domain;

/**
 * @author: guojy
 * @date: 2019/12/27 20:47
 * @Description:
 * @version:
 */
public class Address {
    public Address() {

    }
    private String city;
    private String street;

    @Override
    public String toString() {
        return "Adderss{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }
}
