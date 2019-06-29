package com.example.mvploginexample.login.api;


import okhttp3.ResponseBody;
import retrofit2.Response;



public interface IResponseInterface {

    void onResponseSuccess(Response response, String reqType);

    void onResponseFailure(String responseError, String reqType);

    void onErrorBody(ResponseBody responseBody, String reqType);

}
