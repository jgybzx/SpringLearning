package com.jgybzx.domain;

import java.util.List;

/**
 * @author: guojy
 * @date: 2019/12/27 21:06
 * @Description:
 * @version:
 */
public class ListDemo {
//    private List<String> list;

    private List<Address> addressList;

    @Override
    public String toString() {
        return "ListDemo{" +
                "addressList=" + addressList +
                '}';
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public ListDemo(List<Address> addressList) {
        this.addressList = addressList;
    }
}
