package com.soapgu.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soapgu.core.data.LoginBaseFragment;
import com.soapgu.login.databinding.FragmentLoginBinding;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
public class LoginFragment extends LoginBaseFragment {

    public LoginFragment() {
        // Required empty public constructor
    }


    public static LoginFragment newInstance() {

        return new LoginFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false);

        FragmentLoginBinding binding = FragmentLoginBinding.inflate(inflater,container,false);
        LoginViewModel mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        binding.setDataContext( mViewModel );
        return binding.getRoot();
    }
}