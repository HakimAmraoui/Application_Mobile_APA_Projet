package com.example.apa_projet;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.apa_projet.fragments.FragmentHome;

import java.util.Locale;

public class HomePagerAdapter extends FragmentPagerAdapter {

    private final Context mContext;
    FragmentManager fm;

    public HomePagerAdapter(Context mContext, FragmentManager fm) {
        super(fm);
        this.mContext = mContext;
        this.fm = fm;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FragmentHome.newInstance(fm);
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return"Home".toUpperCase(l);
        }
        return null;
    }

    @Override
    public int getCount() {
        return 1;
    }
}
