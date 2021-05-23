package com.example.apa_projet.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apa_projet.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class FragmentDoctor extends Fragment {

    FragmentManager fm;

    public RecyclerView mRecyclerView;
    private ActivitiesRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    EditText editTextTitle, editTextDescription, editTextCategorie;
    Button selectActivitiesButton, selectPatientButton, suggestButton;

    public FragmentDoctor() {
    }

    public static FragmentDoctor newInstance(FragmentManager fm) {
        FragmentDoctor fragment = new FragmentDoctor();
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
        View view = inflater.inflate(R.layout.fragment_doctor, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewActivities);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ActivitiesRecyclerViewAdapter(getContext(), getActivitiesData());
        mRecyclerView.setAdapter(mAdapter);

        editTextTitle = view.findViewById(R.id.editTextCourseTitle);
        editTextDescription = view.findViewById(R.id.editTextCourseDescription);
        editTextCategorie = view.findViewById(R.id.editTextCourseCategorie);

        selectActivitiesButton = view.findViewById(R.id.selectActivityButton);
        selectPatientButton = view.findViewById(R.id.selectPatientButton);
        suggestButton = view.findViewById(R.id.suggestCourseButton);


        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (editTextTitle.getText().toString().isEmpty()
                        || editTextDescription.getText().toString().isEmpty()
                        || editTextCategorie.getText().toString().isEmpty()) {
                    suggestButton.setEnabled(false);
                } else {
                    suggestButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };
        editTextTitle.addTextChangedListener(textWatcher);
        editTextDescription.addTextChangedListener(textWatcher);
        editTextCategorie.addTextChangedListener(textWatcher);

        selectActivitiesButton.setOnClickListener(v -> {
            FragmentSelectActivities fragmentSelectActivities = FragmentSelectActivities.newInstance(fm);
            fragmentSelectActivities.show(fm, "FragmentSelectActivities");
        });

        selectPatientButton.setOnClickListener(v -> {
            FragmentSelectPatient fragmentSelectPatient = FragmentSelectPatient.newInstance(fm);
            fragmentSelectPatient.show(fm, "FragmentSelectPatient");
        });
        return view;
    }

    private ArrayList<LinkedHashMap<String, String>> getActivitiesData() {
        ArrayList<LinkedHashMap<String, String>> activities = new ArrayList<>();

        LinkedHashMap<String, String> activity1 = new LinkedHashMap<>();
        activity1.put("title", getString(R.string.title) + " 1");
        activity1.put("duration", "2");
        activities.add(activity1);

        LinkedHashMap<String, String> activity2 = new LinkedHashMap<>();
        activity2.put("title", getString(R.string.title) + " 2");
        activity2.put("duration", "3");
        activities.add(activity2);

        return activities;
    }

}
