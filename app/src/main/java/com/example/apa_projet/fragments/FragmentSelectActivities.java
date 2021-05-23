package com.example.apa_projet.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apa_projet.R;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class FragmentSelectActivities extends DialogFragment {

    FragmentManager fm;

    public RecyclerView mRecyclerView;
    private ActivitiesRecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public FragmentSelectActivities() {
    }

    public static FragmentSelectActivities newInstance(FragmentManager fm) {
        FragmentSelectActivities fragment = new FragmentSelectActivities();
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
        View view = inflater.inflate(R.layout.fragment_select_activities, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ActivitiesRecyclerViewAdapter(getContext(), getActivitiesData());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    private ArrayList<LinkedHashMap<String, String>> getActivitiesData() {
        ArrayList<LinkedHashMap<String, String>> activities = new ArrayList<>();

        LinkedHashMap<String, String> activity1 = new LinkedHashMap<>();
        activity1.put("title", "First activity");
        activity1.put("duration", "1");
        activities.add(activity1);

        LinkedHashMap<String, String> activity2 = new LinkedHashMap<>();
        activity2.put("title", "Second activity");
        activity2.put("duration", "3");
        activities.add(activity2);


        return activities;
    }
}
