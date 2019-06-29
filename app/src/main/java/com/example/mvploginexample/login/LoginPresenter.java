package com.example.mvploginexample.login;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

import com.example.mvploginexample.login.api.ApiResponsePresenter;
import com.example.mvploginexample.login.api.IRequestInterface;
import com.example.mvploginexample.login.api.IResponseInterface;
import com.example.mvploginexample.login.model.LoginObj;
import com.example.mvploginexample.login.network.ApiRequestParam;
import com.example.mvploginexample.login.network.ApiRequestTypes;
import com.example.mvploginexample.login.network.AppController;
import com.example.mvploginexample.login.util.AppSettings;
import com.example.mvploginexample.login.util.CommonMethods;
import com.google.gson.TypeAdapter;


import java.io.IOException;



import okhttp3.ResponseBody;
import retrofit2.Response;


/**
 * Created by Sandeep on 23/03/17.
 */

public class LoginPresenter implements ILoginPresenter, IResponseInterface {

        ILoginView iLoginView;
    IRequestInterface iRequestInterface;

    public LoginPresenter(ILoginView iLoginView) {

        this.iLoginView = iLoginView;
        iRequestInterface = new ApiResponsePresenter(this);

    }

    @Override
    public void onResponseSuccess(Response response, String reqType) {
        if (reqType.equalsIgnoreCase(ApiRequestTypes.LOGIN)) {



            if (response.isSuccessful() && response.body() != null) {
                LoginObj login = (LoginObj) response.body();
                iLoginView.onSuccessLogin(login);
            } else if (response.errorBody() != null) {
                onErrorBody(response.errorBody(), reqType);

            } else {
                iLoginView.onFailureLogin("Invalid API");
            }


        }

    }

    @Override
    public void onResponseFailure(String responseError,String reqType) {
        iLoginView.onFailureLogin("Something went wrong! Make sure internet active");


    }

    @Override
    public void onErrorBody(ResponseBody responseBody, String reqType) {
        if (reqType.equalsIgnoreCase(ApiRequestTypes.LOGIN)) {
            TypeAdapter<LoginObj> adapter = AppSettings.gson.getAdapter(LoginObj.class);
            try {
                LoginObj login = adapter.fromJson(responseBody.string());
                iLoginView.onFailureLogin(login.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void login(String email, String password) {

        if (TextUtils.isEmpty(email)) {

            iLoginView.onFailureLogin("Enter valid email id / mobile number");
            return;
        }
        if (TextUtils.isEmpty(password)) {

            iLoginView.onFailureLogin("Enter Password");
            return;
        }
        iRequestInterface.callApi(AppController.getInstance().service.getLogin(AppSettings.getString(AppSettings.PREFERENCE_USER, AppSettings.AUTHENTICATION), ApiRequestParam.getInstance().reqLogin(email, password)), ApiRequestTypes.LOGIN);


    }




}
