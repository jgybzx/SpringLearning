package com.jgybzx.domain;

import java.util.*;

/**
 * @author: guojy
 * @date: 2019/12/23 13:29
 * @Description:
 * @version:
 */
public class People {
    private String usernmae;
    private String age;
    private String address;
    private User user;
    private String[] Myarry;
    private List<String> Mylist;
    private Set<String> Myset;
    private Map<String,String> Mymap;
    private Properties properties;



    public void setUsernmae(String usernmae) {
        this.usernmae = usernmae;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMyarry(String[] myarry) {
        Myarry = myarry;
    }

    public void setMylist(List<String> mylist) {
        Mylist = mylist;
    }

    public void setMyset(Set<String> myset) {
        Myset = myset;
    }

    public void setMymap(Map<String, String> mymap) {
        Mymap = mymap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "People{" +
                "usernmae='" + usernmae + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", user=" + user +
                ", Myarry=" + Arrays.toString(Myarry) +
                ", Mylist=" + Mylist +
                ", Myset=" + Myset +
                ", Mymap=" + Mymap +
                ", properties=" + properties +
                '}';
    }
}
