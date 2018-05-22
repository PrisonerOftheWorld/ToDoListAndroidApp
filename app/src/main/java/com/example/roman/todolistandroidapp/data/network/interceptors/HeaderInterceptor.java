package com.example.roman.todolistandroidapp.data.network.interceptors;

import com.example.roman.todolistandroidapp.data.managers.DataManager;
import com.example.roman.todolistandroidapp.data.managers.PreferencesManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        PreferencesManager pm = DataManager.getInstance().getPreferencesManager();

        Request original = chain.request();
        System.out.println(original.url());
        Request.Builder requestBuilder;
        if(original.url().equals("https://la-todo.herokuapp.com/users") || original.url().equals("https://la-todo.herokuapp.com/login")){
            requestBuilder = original.newBuilder();
        }else {
            requestBuilder = original.newBuilder()
                    .header("Authorization", pm.getAuthToken());
        }
        System.out.println("Interceptor");

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
