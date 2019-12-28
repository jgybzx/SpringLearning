package com.jgybzx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: guojy
 * @date: 2019/12/28 14:58
 * @Description:
 * @version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Integer id;
    private  String name;
    private Double money;

    public Account(String name, Double money) {
        this.name = name;
        this.money = money;
    }
}
