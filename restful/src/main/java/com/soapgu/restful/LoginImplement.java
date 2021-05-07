package com.soapgu.restful;

import com.soapgu.core.api.ILogin;

public class LoginImplement implements ILogin {
    @Override
    public boolean Login(String userName, String password) {
        return userName.equals("admin") && password.equals("123456");
    }
}
