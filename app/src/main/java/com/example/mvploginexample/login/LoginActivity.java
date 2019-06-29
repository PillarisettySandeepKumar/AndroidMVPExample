package com.example.mvploginexample.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;

import com.example.mvploginexample.R;
import com.example.mvploginexample.login.model.LoginObj;
import com.example.mvploginexample.login.network.AppController;
import com.example.mvploginexample.login.util.CommonMethods;

public class LoginActivity extends AppCompatActivity  implements ILoginView {

    public AppCompatEditText login_et_email;
    private AppCompatEditText login_et_password;

    private ProgressDialog progressDialogView;

    ILoginPresenter iLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_et_email=(AppCompatEditText)findViewById(R.id.login_et_email);
        login_et_password=(AppCompatEditText)findViewById(R.id.login_et_password);

        iLoginPresenter = new LoginPresenter(this);

    }

    private void showProgressDialog(String head, String message) {

        progressDialogView = new ProgressDialog(LoginActivity.this);
        progressDialogView.setCancelable(false);
        progressDialogView.setMessage(message);
        progressDialogView.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialogView.show();
    }


    private void cancelPrgressDialog() {

        try {
            progressDialogView.dismiss();
        } catch (IllegalArgumentException e) {

        }
    }


    public void login() {

        showProgressDialog("","please wait..");

        iLoginPresenter.login(login_et_email.getText().toString().trim(), login_et_password.getText().toString().trim());

    }


    @Override
    public void onFailureLogin(String s) {
        cancelPrgressDialog();
        if (s.equalsIgnoreCase("Enter valid email id / mobile number")) {
            login_et_email.setTextColor(Color.RED);


            return;

        } if (s.equalsIgnoreCase("Enter Password")) {

            login_et_password.setTextColor(Color.RED);

            return;

        }
    }

    @Override
    public void onSuccessLogin(LoginObj body) {
        cancelPrgressDialog();


    }

}
