package com.example.mvploginexample.login.network;

import android.app.Application;

import com.example.mvploginexample.login.api.RestApi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AppController extends Application {

    public static final String TAG = AppController.class.getSimpleName();

    private static AppController mInstance;
    public RestApi service;
    Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                final Request request = chain.request().newBuilder()
                        .header("Authorization", "")
                        .build();
                return chain.proceed(request);
            }
        }).connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(ApiConstants.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())

                //  .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        service = retrofit.create(RestApi.class);


    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }


}
