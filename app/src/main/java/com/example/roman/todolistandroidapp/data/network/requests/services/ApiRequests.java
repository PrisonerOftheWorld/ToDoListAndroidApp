package com.example.roman.todolistandroidapp.data.network.requests.services;

import com.example.roman.todolistandroidapp.data.network.requests.models.LoginBody;
import com.example.roman.todolistandroidapp.data.network.requests.models.LoginResponse;
import com.example.roman.todolistandroidapp.data.network.requests.models.RegistrationBody;
import com.example.roman.todolistandroidapp.data.network.requests.models.RegistrationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Roman on 18.05.2018.
 */

public interface ApiRequests {

    @POST("/users")
    Call<RegistrationResponse> registerUser(@Header("Content-Type") String content_type, @Body RegistrationBody registrationBody);

    @POST("/login")
    Call<LoginResponse> loginUser(@Header("Content-Type") String content_type, @Body LoginBody loginBody);

}
