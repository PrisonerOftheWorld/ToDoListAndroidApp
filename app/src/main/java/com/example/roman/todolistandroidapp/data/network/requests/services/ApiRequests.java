package com.example.roman.todolistandroidapp.data.network.requests.services;

import com.example.roman.todolistandroidapp.data.network.requests.models.Goal;
import com.example.roman.todolistandroidapp.data.network.requests.models.GoalCreateRequestBody;
import com.example.roman.todolistandroidapp.data.network.requests.models.GoalCreateResponseBody;
import com.example.roman.todolistandroidapp.data.network.requests.models.GoalsList;
import com.example.roman.todolistandroidapp.data.network.requests.models.LoginBody;
import com.example.roman.todolistandroidapp.data.network.requests.models.LoginResponse;
import com.example.roman.todolistandroidapp.data.network.requests.models.RegistrationBody;
import com.example.roman.todolistandroidapp.data.network.requests.models.RegistrationResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
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

    @GET("/goals")
    Call<GoalsList> goals();

    @POST("/goal")
    Call<GoalCreateResponseBody> createGoal(@Body GoalCreateRequestBody goalCreateRequestBody);

}
