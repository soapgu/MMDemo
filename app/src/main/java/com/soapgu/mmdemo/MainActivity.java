package com.soapgu.mmdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.soapgu.core.data.LoginBaseFragment;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    @Inject
    LoginBaseFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container, loginFragment, null)
                .commit();
    }
}