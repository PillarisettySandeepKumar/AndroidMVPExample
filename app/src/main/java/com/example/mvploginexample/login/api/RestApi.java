package com.example.mvploginexample.login.api;


import com.example.mvploginexample.login.model.LoginObj;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;

import retrofit2.http.POST;


public interface RestApi {

    @POST("customer/login")
    Call<LoginObj> getLogin(@Header("Authorization") String authorization, @Body JsonObject obj);


}

