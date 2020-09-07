package com.myapp.admin2d;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

     D2Fragment d2Fragment = new D2Fragment();
     D3Fragment d3Fragment = new D3Fragment();
    Fragment activeFrag;
    BottomNavigationView bottomNavigationView;
    FragmentManager manager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        manager.beginTransaction().add(R.id.fragment_containner, d3Fragment).hide(d3Fragment).commit();
        manager.beginTransaction().add(R.id.fragment_containner, d2Fragment).commit();
        activeFrag = d2Fragment;

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFrag = null;

                switch (item.getItemId()) {
                    case R.id.d2_item:
                        selectedFrag = d2Fragment;
                        break;
                    case R.id.d3_item:
                        selectedFrag = d3Fragment;
                        break;
                }
                manager.beginTransaction().hide(activeFrag).show(selectedFrag).commit();
                activeFrag = selectedFrag;
                return true;
            }
        });
    }
}