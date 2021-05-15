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
import androidx.fragment.app.FragmentManager;

import com.example.apa_projet.R;

public class FragmentCreateActivity extends DialogFragment {

    EditText editTextTitle, editTextDescription, editTextDuration;
    Button createButton;
    ProgressBar loading;
    FragmentManager fm;

    public FragmentCreateActivity() {
    }


    public static FragmentCreateActivity newInstance(FragmentManager fm) {
        FragmentCreateActivity fragment = new FragmentCreateActivity();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_activity, container, false);

        editTextTitle = view.findViewById(R.id.editTextActivityTitle);
        editTextDescription = view.findViewById(R.id.editTextActivityDescription);
        editTextDuration = view.findViewById(R.id.editTextActivityDuration);
        createButton = view.findViewById(R.id.addActivityButton);
        loading = view.findViewById(R.id.loading);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editTextTitle.getText().toString().isEmpty()
                        || editTextDescription.getText().toString().isEmpty()
                        || editTextDuration.getText().toString().isEmpty()) {
                    createButton.setEnabled(false);
                } else {
                    createButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };
        editTextTitle.addTextChangedListener(textWatcher);
        editTextDescription.addTextChangedListener(textWatcher);
        editTextDuration.addTextChangedListener(textWatcher);

        createButton.setOnClickListener(v -> {
            loading.setVisibility(View.VISIBLE);
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                loading.setVisibility(View.GONE);
                // Do stuff
                getDialog().dismiss();
            }, 1000);
        });

        return view;    }
}
