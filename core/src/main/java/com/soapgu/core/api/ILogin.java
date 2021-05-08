package com.soapgu.core.api;

import io.reactivex.rxjava3.core.Single;

public interface ILogin {
    Single<Boolean> Login(String userName , String passwrod );
}
