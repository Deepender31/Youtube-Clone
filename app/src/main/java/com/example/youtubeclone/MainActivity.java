package com.example.youtubeclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        BottomNavigationView bottomnav=findViewById(R.id.bottom_na);
        bottomnav.setOnNavigationItemSelectedListener(navListner);
        getSupportFragmentManager().beginTransaction().replace(R.id.framenav , new home()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListner=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selected =null;
                    switch(item.getItemId())    {
                        case R.id.navigation_home:
                            selected = new home();
                            break;
                        case R.id.navigation_explore:
                            selected = new explore();
                            break;
                        case R.id.navigation_add:
                            selected = new add();
                            break;
                        case R.id.navigation_sub:
                            selected = new sub();
                            break;
                        case R.id.navigation_library:
                            selected = new library();
                            break;


                    }
                     getSupportFragmentManager().beginTransaction().replace(R.id.framenav , selected).commit();
                    return true;
                }
            };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }
}