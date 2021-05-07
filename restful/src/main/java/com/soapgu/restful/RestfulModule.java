package com.soapgu.restful;

import com.soapgu.core.api.ILogin;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RestfulModule {

    @Singleton
    @Provides
    public ILogin provideILogin() {
        return new LoginImplement();
    }
}
