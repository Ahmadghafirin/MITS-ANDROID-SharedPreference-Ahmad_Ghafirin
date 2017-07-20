package com.example.ahmad.sharedpreference;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ahmad on 19/07/17.
 */

public class Person implements Parcelable {
    private String name, address, noHp, email, pass;

    public Person(String name, String address, String noHp, String email, String pass) {
        this.name = name;
        this.address = address;
        this.noHp = noHp;
        this.email = email;
        this.pass = pass;
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

    protected Person(Parcel in) {
        name = in.readString();
        address = in.readString();
        noHp = in.readString();
        email = in.readString();
        pass = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
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
        return "Hello My Name is :" + name + "\nMy Address is at :" + address +
                "\nMy Phone Number is :" + noHp + "\nMy Email is :" + email;
    }
}
