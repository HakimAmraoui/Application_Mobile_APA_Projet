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

public class FragmentCreateStructure extends DialogFragment {

    EditText editTextName, editTextDisciplines, editTextPathologies;
    Button addButton;
    ProgressBar loading;

    public FragmentCreateStructure() {
    }

    public static FragmentCreateStructure newInstance() {
        FragmentCreateStructure fragment = new FragmentCreateStructure();
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
        View view = inflater.inflate(R.layout.fragment_create_structure, container, false);

        editTextName = view.findViewById(R.id.editTextStructureName);
        editTextDisciplines = view.findViewById(R.id.editTextStructureDiscipline);
        editTextPathologies = view.findViewById(R.id.editTextStructurePathologies);
        addButton = view.findViewById(R.id.addStructureButton);
        loading = view.findViewById(R.id.loading);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editTextName.getText().toString().isEmpty()
                        || editTextDisciplines.getText().toString().isEmpty()
                        || editTextPathologies.getText().toString().isEmpty()) {
                    addButton.setEnabled(false);
                } else {
                    addButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };
        editTextName.addTextChangedListener(textWatcher);
        editTextDisciplines.addTextChangedListener(textWatcher);
        editTextPathologies.addTextChangedListener(textWatcher);

        addButton.setOnClickListener(v -> {
            loading.setVisibility(View.VISIBLE);
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                loading.setVisibility(View.GONE);
                // Do stuff
                getDialog().dismiss();
            }, 1000);
        });

        return view;    }

}

