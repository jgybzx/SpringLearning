package com.jgybzx.service.impl;

import com.jgybzx.domain.User;
import com.jgybzx.service.UserService;

/**
 * @author: guojy
 * @date: 2019/12/23 11:44
 * @Description:
 * @version:
 */
public class UserServiceImpl implements UserService {
    public UserServiceImpl() {
    }

    private String name;
    private Integer age;
    private User user;

    public UserServiceImpl(String name, Integer age121212, User user) {
        this.name = name;
        this.age = age121212;
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", user=" + user +
                '}';
    }

    public void save() {

            System.out.println(name);
            System.out.println(age);
            System.out.println(user);
        }

}
