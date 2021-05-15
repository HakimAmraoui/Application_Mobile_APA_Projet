package com.example.apa_projet.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.apa_projet.R;

public class FragmentHome extends Fragment {

    Button loginButton, registerButton, createStructureButton, createSessionButton, createActivityButton;
    FragmentManager fm;

    public FragmentHome() {

    }

    public static FragmentHome newInstance(FragmentManager fm) {
        FragmentHome fragment = new FragmentHome();
        fragment.fm = fm;
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        loginButton = view.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(v -> {
            FragmentLogin fragmentLogin = FragmentLogin.newInstance();
            fragmentLogin.show(fm, "FragmentLogin");
        });

        registerButton = view.findViewById(R.id.registerButton);
        registerButton.setOnClickListener(v -> {
            FragmentRegister fragmentRegister = FragmentRegister.newInstance();
            fragmentRegister.show(fm, "FragmentRegister");
        });

        createStructureButton = view.findViewById(R.id.addStructureButton);
        createStructureButton.setOnClickListener(v -> {
            FragmentCreateStructure fragmentCreateStructure = FragmentCreateStructure.newInstance();
            fragmentCreateStructure.show(fm, "FragmentCreateStructure");
        });

        createSessionButton = view.findViewById(R.id.addSessionButton);
        createSessionButton.setOnClickListener(v -> {
           FragmentCreateSession fragmentCreateSession = FragmentCreateSession.newInstance();
           fragmentCreateSession.show(fm, "addSession");
        });

        createActivityButton = view.findViewById(R.id.addActivityButton);
        createActivityButton.setOnClickListener(v -> {
            FragmentCreateActivity fragmentCreateActivity = FragmentCreateActivity.newInstance(fm);
            fragmentCreateActivity.show(fm, "FragmentCreateActivity");
        });

        return view;
    }
}
