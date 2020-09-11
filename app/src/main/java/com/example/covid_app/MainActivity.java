package com.example.covid_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.profile:
                        Intent home_intent = new Intent(MainActivity.this, ProfileActivity.class);
                        startActivity(home_intent);
                        return true;
                    case R.id.home:
                        Intent profile_intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(profile_intent);
                        return true;
                    case R.id.propreté:
                        Toast.makeText(MainActivity.this, "Propreté",Toast.LENGTH_SHORT).show();break;
                    case R.id.alimentation:
                        Toast.makeText(MainActivity.this, "Alimentation",Toast.LENGTH_SHORT).show();break;
                    case R.id.distraction:
                        Toast.makeText(MainActivity.this, "Distraction",Toast.LENGTH_SHORT).show();break;
                    case R.id.conseils:
                        Toast.makeText(MainActivity.this, "Conseils",Toast.LENGTH_SHORT).show();break;
                    case R.id.to_do_list:
                        Toast.makeText(MainActivity.this, "TODO",Toast.LENGTH_SHORT).show();break;
                    default:
                        return MainActivity.super.onOptionsItemSelected(item);
                }


                return true;

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

}
