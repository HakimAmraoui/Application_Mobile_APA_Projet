package com.example.apa_projet.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.apa_projet.R;

public class FragmentRegister extends DialogFragment {

    EditText editTextUsername, editTextName, editTextPassword, editTextAge;
    Button buttonRegister;
    ProgressBar loading;

    public FragmentRegister() {
    }


    public static FragmentRegister newInstance() {
        FragmentRegister fragment = new FragmentRegister();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        editTextName = view.findViewById(R.id.editTextName);
        editTextUsername = view.findViewById(R.id.editTextUserName);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        buttonRegister = view.findViewById(R.id.buttonRegister);
        loading = view.findViewById(R.id.loading);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editTextName.getText().toString().isEmpty()
                        || editTextUsername.getText().toString().isEmpty()
                        || editTextPassword.getText().toString().isEmpty()) {
                    buttonRegister.setEnabled(false);
                } else {
                    buttonRegister.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };
        editTextName.addTextChangedListener(textWatcher);
        editTextUsername.addTextChangedListener(textWatcher);
        editTextPassword.addTextChangedListener(textWatcher);

        buttonRegister.setOnClickListener(v -> {
            loading.setVisibility(View.VISIBLE);
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                loading.setVisibility(View.GONE);
                // Do stuff
                getDialog().dismiss();
            }, 1000);
        });

        return view;    }
}


