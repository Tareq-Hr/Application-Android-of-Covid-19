package com.example.covid_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class inscription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
    }

    public void goToLogin(View view) {
        Intent intent = new Intent(inscription.this, LoginActivity.class);
        startActivity(intent);
    }

    public void Login(View view) {
        Intent intent = new Intent(inscription.this, MainActivity.class);
        startActivity(intent);
    }
}