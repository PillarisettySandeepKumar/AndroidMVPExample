package com.example.mvploginexample.login;


import com.example.mvploginexample.login.model.LoginObj;



/**
 * Created by Sandeep on 23/03/17.
 */

public interface ILoginView {

    void onFailureLogin(String s);

    void onSuccessLogin(LoginObj body);


}
