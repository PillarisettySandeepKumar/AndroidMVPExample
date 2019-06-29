package com.example.mvploginexample.login.api;


import retrofit2.Call;

/**
 * Created by FuGenX-10 on 29-11-2016.
 */

public interface IRequestInterface {

    void callApi(Call call, final String reqType);
}
