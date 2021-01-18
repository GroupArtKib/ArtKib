package com.example.artkib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class secondpage extends AppCompatActivity {
    DatabaseHelper db;
    EditText username1;
    EditText password1;
    Button login;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);
        db= new DatabaseHelper(this);
        username1 = (EditText)findViewById(R.id.username);
        password1 = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.button2);
        register = (Button)findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(secondpage.this, registerpage.class);
                startActivity(registerIntent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = username1.getText().toString().trim();
                String password = password1.getText().toString().trim();
                Boolean res = db.checkUser(username, password);
                if(res == true)
                {
                    Intent HomePage = new Intent(secondpage.this,mainpage.class);
                    startActivity(HomePage);
                }
                else
                {
                    Toast.makeText(secondpage.this,"Login Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}