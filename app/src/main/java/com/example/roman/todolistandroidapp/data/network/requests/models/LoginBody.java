package com.example.roman.todolistandroidapp.data.network.requests.models;

public class LoginBody {

    String email;
    String password;

    public LoginBody(String email, String password){
        this.email = email;
        this.password = password;
    }

}
