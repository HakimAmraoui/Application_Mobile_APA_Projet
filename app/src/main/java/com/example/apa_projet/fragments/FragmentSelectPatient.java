package com.example.apa_projet.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apa_projet.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class FragmentSelectPatient extends DialogFragment {

    FragmentManager fm;

    public RecyclerView mRecyclerView;
    private PatientsRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public FragmentSelectPatient() {
    }

    public static FragmentSelectPatient newInstance(FragmentManager fm) {
        FragmentSelectPatient fragment = new FragmentSelectPatient();
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
        View view = inflater.inflate(R.layout.fragment_select_patient, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new PatientsRecyclerViewAdapter(getContext(), getPatientData());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    private ArrayList<LinkedHashMap<String, String>> getPatientData() {
        ArrayList<LinkedHashMap<String, String>> patients = new ArrayList<>();

        LinkedHashMap<String, String> patient1 = new LinkedHashMap<>();
        patient1.put("name", getString(R.string.name) + " Adam");
        patient1.put("age", "20");
        patients.add(patient1);

        LinkedHashMap<String, String> patient2 = new LinkedHashMap<>();
        patient2.put("name", getString(R.string.name) + " Bruno");
        patient2.put("age", "21");
        patients.add(patient2);


        return patients;
    }
}
