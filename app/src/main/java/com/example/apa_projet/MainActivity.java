package com.example.apa_projet;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private HomePagerAdapter homePagerAdapter;
    private ViewPager viewPager;
    FragmentManager fm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();

        homePagerAdapter = new HomePagerAdapter(this, fm);
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(homePagerAdapter);

    }
}