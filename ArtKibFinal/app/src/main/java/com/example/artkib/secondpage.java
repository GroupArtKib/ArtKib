package com.example.artkib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class secondpage extends AppCompatActivity {
    DatabaseHelper db;
    TextInputLayout Password, UserName;
    Button reg, log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);
        db=new DatabaseHelper(this);

        Password = findViewById(R.id.username);
        UserName = findViewById(R.id.password);
        log = findViewById(R.id.log_btn);
        reg = findViewById(R.id.reg_btn);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(secondpage.this,registerpage.class);
                startActivity(LoginIntent);
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = UserName.getEditText().getText().toString();
                String password = Password.getEditText().getText().toString();

                if (username.equals("")||password.equals("")){
                    Toast.makeText(secondpage.this,"Please Enter all the fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean res = db.checkUser(username, password);
                    if (res == true) {

                        Intent HomePage = new Intent(secondpage.this, mainpage.class);
                        startActivity(HomePage);
                    } else {
                        Toast.makeText(secondpage.this, "Login Error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
