package com.example.fitnesstrackerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.fitnesstrackerapp.adapter.Adapter;
import com.example.fitnesstrackerapp.fragment.HistoryFragment;
import com.example.fitnesstrackerapp.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    final Fragment fragment1 = new HomeFragment();
    final Fragment fragment2 = new HistoryFragment();
    Fragment active = fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Adapter adapter = new Adapter(getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment2)
                .hide(fragment2)
                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment1)
                .commit();
    }

    @SuppressLint("NonConstantResourceId")
    private final BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            menuItem -> {

                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction().hide(active).show(fragment1).commit();
                        active = fragment1;
                        break;

                    case R.id.nav_history:
                        getSupportFragmentManager().beginTransaction().hide(active).show(fragment2).commit();
                        active = fragment2;
                        break;
                }



                return true;
            };
}