package com.example.ahmad.sharedpreference.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ahmad on 19/07/17.
 */

public class User implements Parcelable {
    private String name, address, noHp, email, pass;
    private int id;

    public User(String name, String address, String noHp, String email, String pass) {
        this.name = name;
        this.address = address;
        this.noHp = noHp;
        this.email = email;
        this.pass = pass;
    }

    public User() {
    }

    public String getPass() {
        return pass;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    protected User(Parcel in) {
        name = in.readString();
        address = in.readString();
        noHp = in.readString();
        email = in.readString();
        pass = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
        dest.writeString(noHp);
        dest.writeString(email);
        dest.writeString(pass);
    }

    @Override
    public String toString() {
        return "Name :" + name + "\tAddress :" + address +
                "\tPhone Number :" + pass + "\tEmail :" + noHp + "\tPassword :" + email;
    }
}