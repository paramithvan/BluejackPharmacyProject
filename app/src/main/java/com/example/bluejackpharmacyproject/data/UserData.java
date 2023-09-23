package com.example.bluejackpharmacyproject.data;

public class UserData {
    public static int UserId;
    public String name;
    public String phoneNum;
    public String email;
    public String password;

    public static int getId() {
        return UserId;
    }

    public void setId(int UserId) {

        this.UserId = UserId;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getPhoneNum() {

        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {

        this.phoneNum = phoneNum;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public UserData(int UserId, String name, String phoneNum, String email, String password){
        this.UserId = UserId;
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
        this.password = password;
    }

}
