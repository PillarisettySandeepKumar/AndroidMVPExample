package com.example.mvploginexample.login.api;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by tipp on 22/03/17.
 * <p>
 * This Class is required to call Api and give response i.e Success / Failure
 */

public class ApiResponsePresenter implements IRequestInterface {


    public IResponseInterface iResponseInterface;

    Call mcall;
    String mreqType;

    public ApiResponsePresenter(IResponseInterface iResponseInterface) {
        this.iResponseInterface = iResponseInterface;
    }

    @Override
    public void callApi(Call call, final String reqType) {
        mcall = call;
        mreqType = reqType;
        apiRequest(mcall, mreqType);
    }

    private void apiRequest(Call call, final String reqType) {
        call.clone().enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (response.code() == 401) {

                } else {
                    if (response.isSuccessful() && response.body() != null) {

                        iResponseInterface.onResponseSuccess(response, reqType);
                    } else if (response.errorBody() != null) {

                        iResponseInterface.onErrorBody(response.errorBody(), reqType);
                    } else {
                        iResponseInterface.onResponseFailure("Invalid Response " + response.message(), reqType);
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable throwable) {
                if (throwable instanceof ConnectException) {
                    iResponseInterface.onResponseFailure("Please check your internet connection", reqType);
                } else if (throwable instanceof SocketTimeoutException) {
                    throwable.printStackTrace();
                    iResponseInterface.onResponseFailure("Timeout, Please Try Again", reqType);
                } else {
                    iResponseInterface.onResponseFailure("Something Went Wrong", reqType);
                }
            }
        });
    }






}

