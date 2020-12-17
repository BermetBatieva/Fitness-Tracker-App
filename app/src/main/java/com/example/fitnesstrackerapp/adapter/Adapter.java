package com.example.fitnesstrackerapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.fitnesstrackerapp.fragment.HistoryFragment;
import com.example.fitnesstrackerapp.fragment.HomeFragment;

public class Adapter extends FragmentPagerAdapter {
    public Adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new HistoryFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
