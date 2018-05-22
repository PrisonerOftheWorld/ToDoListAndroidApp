package com.example.roman.todolistandroidapp.data.network.requests.models;

public class RegistrationBody {

    String displayName;
    String email;
    String password;

    public RegistrationBody(String displayName, String email, String password){
        this.displayName = displayName;
        this.email = email;
        this.password = password;
    }

}
