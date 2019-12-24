package com.jgybzx.domain;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author: guojy
 * @date: 2019/12/24 16:01
 * @Description:
 * @version:
 */
public class Account {
    public Account() {
    }
    private Integer id;
    //相当于直接赋值，常配合jdbc配置文件使用
    private String name;
    private Double money;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Account(Integer id, String name, Double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }
}
