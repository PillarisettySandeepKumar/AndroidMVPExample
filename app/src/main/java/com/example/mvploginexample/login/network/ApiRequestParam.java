package com.example.mvploginexample.login.network;


import android.util.Log;

import com.google.gson.JsonObject;


public class ApiRequestParam {


    static ApiRequestParam apiRequestParam = null;

    private ApiRequestParam() {

    }

    public static ApiRequestParam getInstance() {
        if (apiRequestParam == null)
            return new ApiRequestParam();
        else
            return apiRequestParam;
    }

    private JsonObject respParamObj;


    //login
    public JsonObject reqLogin(String mobileno, String password) {
        try {
            respParamObj = new JsonObject();
            if (!mobileno.equalsIgnoreCase("")) respParamObj.addProperty("mobileNumber", mobileno);
            if (!password.equalsIgnoreCase("")) respParamObj.addProperty("password", password);
            Log.d("REQ_LOGIN", "url login " + respParamObj.toString());
            return respParamObj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
