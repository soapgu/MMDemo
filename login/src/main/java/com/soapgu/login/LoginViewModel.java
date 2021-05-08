package com.soapgu.login;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.Bindable;

import com.soapgu.core.ObservableViewModel;
import com.soapgu.core.api.ILogin;

import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

@HiltViewModel
public class LoginViewModel extends ObservableViewModel {

    private String message = "please login";
    private final CompositeDisposable disposables = new CompositeDisposable();
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
        this.setMessage( "Waiting..." );

        disposables.add( this.login.Login(userName, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( result-> this.setMessage( String.format( "Login Result:%s", result ) )
                    , error-> this.setMessage( String.format( "Login Error:%s", error.getMessage())) )
                );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposables.dispose();
    }
}
