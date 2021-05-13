package com.example.apa_projet.fragments;

import android.app.DatePickerDialog;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FragmentCreateSession extends DialogFragment {

    EditText dateEditText, durationEditText;
    Button createButton;
    ProgressBar loading;

    public FragmentCreateSession() {
    }

    public static FragmentCreateActivity newInstance() {
        FragmentCreateActivity fragment = new FragmentCreateActivity();
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
        View view = inflater.inflate(R.layout.fragment_create_session, container, false);

        dateEditText = view.findViewById(R.id.editTextSessionDate);
        durationEditText = view.findViewById(R.id.editTextSessionDuration);
        createButton = view.findViewById(R.id.buttonCreateSession);

        final Calendar myCalendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date = (view1, year, month, dayOfMonth) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            String myFormat = "dd/MM/yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);
            dateEditText.setText(sdf.format(myCalendar.getTime()));
        };
        dateEditText.setOnClickListener(v -> {
            new DatePickerDialog(getContext(), date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (dateEditText.getText().toString().isEmpty()
                        || durationEditText.getText().toString().isEmpty()) {
                    createButton.setEnabled(false);
                } else {
                    createButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };
        dateEditText.addTextChangedListener(textWatcher);
        durationEditText.addTextChangedListener(textWatcher);

        createButton.setOnClickListener(v -> {
            loading.setVisibility(View.VISIBLE);
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                loading.setVisibility(View.GONE);
                getDialog().dismiss();
            }, 1000);
        });

        return view;
    }
}
