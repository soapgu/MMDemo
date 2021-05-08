package com.soapgu.restful;

import com.soapgu.core.api.ILogin;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Single;

public class LoginImplement implements ILogin {
    @Override
    public Single<Boolean> Login(String userName, String password) {
        return Single.timer( 3, TimeUnit.SECONDS)
                .map( t-> userName.equals("admin") && password.equals("123456") );
    }
}
