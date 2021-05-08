package com.soapgu.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.Bindable;

import com.soapgu.core.ObservableViewModel;
import com.soapgu.core.api.ILogin;

import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class LoginViewModel extends ObservableViewModel {

    private String message = "please login";

    ILogin login;

    @Inject
    public LoginViewModel(@NonNull Application application, ILogin login) {
        super(application);
        this.login = login;
    }


    @Bindable
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        this.notifyPropertyChanged(BR.message);
    }

    public void CheckLogin( String userName, String password) {
        this.setMessage( String.format( "Login Result:%s",this.login.Login(userName, password) ) );
    }
}
