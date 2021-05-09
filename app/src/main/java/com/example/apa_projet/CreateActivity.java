package com.example.apa_projet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateActivity extends AppCompatActivity {

    private EditText activityTitle;
    private EditText activityDescription;
    private Spinner activityDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
    }
}