package com.example.artkib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputLayout;

public class profilepage extends AppCompatActivity {


    DatabaseHelper db;
    TextView textView;
    Button out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilepage);

        DatabaseHelper db = new DatabaseHelper(this);

        textView = findViewById(R.id.profilename);

        textView.setText("This app is made by a group of 4 students");

        //StartLog Out
        out = findViewById(R.id.out_btn);
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profilepage.this, secondpage.class);
                startActivity(intent);
            }
        });//End Log Out

        //Start Navigation Bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.BottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.profile);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        return true;
                    case R.id.discover:
                        startActivity(new Intent(getApplicationContext(), discoverpage.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), mainpage.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        }); //End Navigation Bar


    }

}
