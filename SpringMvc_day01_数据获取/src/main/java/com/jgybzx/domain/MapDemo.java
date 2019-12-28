package com.jgybzx.domain;

import java.util.Map;

/**
 * @author: guojy
 * @date: 2019/12/27 21:20
 * @Description:
 * @version:
 */
public class MapDemo {

    private Map<String,String> stringMap;


    private Map<String,Address> addressMap;

    public MapDemo(Map<String, String> stringMap, Map<String, Address> addressMap) {
        this.stringMap = stringMap;
        this.addressMap = addressMap;
    }

    public MapDemo() {
    }

    @Override
    public String toString() {
        return "MapDemo{" +
                "stringMap=" + stringMap +
                ", addressMap=" + addressMap +
                '}';
    }

    public Map<String, String> getStringMap() {
        return stringMap;
    }

    public void setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }

    public Map<String, Address> getAddressMap() {
        return addressMap;
    }

    public void setAddressMap(Map<String, Address> addressMap) {
        this.addressMap = addressMap;
    }
}
