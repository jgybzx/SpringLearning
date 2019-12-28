package com.jgybzx.domain;

import java.util.List;

/**
 * @author: guojy
 * @date: 2019/12/27 20:46
 * @Description:
 * @version:
 */
public class People {
    public People() {
    }

    private String username;
    private String age;
    private Address address;
    private List<String> list;

    public People(String username, String age, Address address, List<String> list) {
        this.username = username;
        this.age = age;
        this.address = address;
        this.list = list;
    }

    @Override
    public String toString() {
        return "People{" +
                "username='" + username + '\'' +
                ", age='" + age + '\'' +
                ", address=" + address +
                ", list=" + list +
                '}';
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public People(String username, String age, Address address) {
        this.username = username;
        this.age = age;
        this.address = address;
    }
}
