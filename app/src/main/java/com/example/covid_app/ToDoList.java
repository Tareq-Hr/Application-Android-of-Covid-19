package com.example.covid_app;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class ToDoList extends AppCompatActivity {

    private RecyclerView brandRecyclerView;
    private NavigationView nv;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;

    //Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ToDoList.this,
                        SecondActivity.class);
                startActivity(intent);

            }
        });

        brandRecyclerView = (RecyclerView) findViewById(R.id.brands_lst);


        dl = (DrawerLayout)findViewById(R.id.activity_to_do_list);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView)findViewById(R.id.nv);


        //Navigation
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.profile:
                        Intent home_intent = new Intent(ToDoList.this, ProfileActivity.class);
                        startActivity(home_intent);
                        return true;
                    case R.id.home:
                        Intent profile_intent = new Intent(ToDoList.this, MainActivity.class);
                        startActivity(profile_intent);
                        return true;
                    case R.id.propreté:
                        Intent propreté_intent = new Intent(ToDoList.this, proprete.class);
                        startActivity(propreté_intent);
                        return true;
                    case R.id.alimentation:
                        Intent alimentation_intent = new Intent(ToDoList.this, alimentation.class);
                        startActivity(alimentation_intent);
                        return true;
                    case R.id.distraction:
                        Intent distraction_intent = new Intent(ToDoList.this, interfaces.class);
                        startActivity(distraction_intent);
                        return true;
                    case R.id.conseils:
                        Intent conseil_intent = new Intent(ToDoList.this, conseils.class);
                        startActivity(conseil_intent);
                        return true;
                    case R.id.to_do_list:
                        Intent todo_intent = new Intent(ToDoList.this, ToDoList.class);
                        startActivity(todo_intent);
                        return true;
                    case R.id.logout:
                        Intent logout_intent = new Intent(ToDoList.this, LoginActivity.class);
                        startActivity(logout_intent);
                        return true;
                    default:
                        return ToDoList.super.onOptionsItemSelected(item);
                }
            }
        });


        //RecyclerView layout manager
        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        brandRecyclerView.setLayoutManager(recyclerLayoutManager);

        //RecyclerView item decorator
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(brandRecyclerView.getContext(),
                        recyclerLayoutManager.getOrientation());
        brandRecyclerView.addItemDecoration(dividerItemDecoration);

        //RecyclerView adapater
        EventFilterRecyclerViewAdapter recyclerViewAdapter = new
                EventFilterRecyclerViewAdapter(getBrands(),this);
        brandRecyclerView.setAdapter(recyclerViewAdapter);
    }


    private List<EventClass> getBrands(){
        List<EventClass> modelList = new ArrayList<EventClass>();
        modelList.add(new EventClass(1,"Learn Android","learn xml","22/09/2020","19:00",true));
        modelList.add(new EventClass(1,"Learn Android","learn xml","22/09/2020","19:00",false));
        modelList.add(new EventClass(1,"Learn Android","learn xml","22/09/2020","19:00",true));
        modelList.add(new EventClass(1,"Learn Android","learn xml","22/09/2020","19:00",false));
        modelList.add(new EventClass(1,"Learn Android","learn xml","22/09/2020","19:00",false));
        modelList.add(new EventClass(1,"Learn Android","learn xml","22/09/2020","19:00",true));


        return modelList;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
