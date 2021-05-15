package com.example.apa_projet.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.apa_projet.R;

public class FragmentCalendar extends Fragment {

    FragmentManager fm;

    public FragmentCalendar() {
    }

    public static FragmentCalendar newInstance(FragmentManager fm){
        FragmentCalendar fragment = new FragmentCalendar();
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
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);

        // TODO: 15/05/2021 Add the calendar

        return view;
    }
}
