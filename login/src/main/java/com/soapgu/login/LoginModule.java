package com.soapgu.login;

import com.soapgu.core.data.LoginBaseFragment;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public class LoginModule {

    @Provides
    public LoginBaseFragment provideLoginBaseFragment(){
        return LoginFragment.newInstance();
    }
}
