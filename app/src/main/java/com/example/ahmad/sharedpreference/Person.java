package com.example.ahmad.sharedpreference;


/**
 * Created by ahmad on 17/07/17.
 */

public class Person {
    private String name;
    private String email;
    private int noHp;
    private String address;

    public Person(String name, String email, int noHp, String address) {
        this.name = name;
        this.email = email;
        this.noHp = noHp;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getNoHp() {
        return noHp;
    }

    public String getAddress() {
        return address;
    }

    public String info() {
        return "Hello my Name is :" + name + "\n" + "my Address is at :" + address + "\n" + "my Phone Number is :" +
                noHp + "\n" + "my Email is :" + email;
    }
}
