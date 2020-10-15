package com.example.covid_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    private TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.textView);

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
                        Intent propreté_intent = new Intent(MainActivity.this, proprete.class);
                        startActivity(propreté_intent);
                        return true;
                    case R.id.alimentation:
                        Intent alimentation_intent = new Intent(MainActivity.this, alimentation.class);
                        startActivity(alimentation_intent);
                        return true;
                    case R.id.distraction:
                        Intent distraction_intent = new Intent(MainActivity.this, interfaces.class);
                        startActivity(distraction_intent);
                        return true;
                    case R.id.conseils:
                        Intent conseil_intent = new Intent(MainActivity.this, conseils.class);
                        startActivity(conseil_intent);
                        return true;
                    case R.id.to_do_list:
                        Intent todo_intent = new Intent(MainActivity.this, ToDoList.class);
                        startActivity(todo_intent);
                        return true;
                    case R.id.logout:
                        Intent logout_intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(logout_intent);
                        return true;
                    default:
                        return MainActivity.super.onOptionsItemSelected(item);
                }
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
