package com.example.artkib;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class registerpage extends AppCompatActivity {
    DatabaseHelper db;
    TextInputLayout fname, UserName, Password, CPassword, Email;
    Button reg, log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);
        db=new DatabaseHelper(this);

        fname = findViewById(R.id.name);
        UserName = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        Email = findViewById(R.id.email);
        CPassword = findViewById(R.id.Cpassword);
        reg = findViewById(R.id.reg_btn);
        log = findViewById(R.id.log_btn);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(registerpage.this,secondpage.class);
                startActivity(LoginIntent);
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= fname.getEditText().getText().toString();
                String username= UserName.getEditText().getText().toString();
                String email= Email.getEditText().getText().toString();
                String password= Password.getEditText().getText().toString();
                String confirmpass= CPassword.getEditText().getText().toString();

                if (password.equals(confirmpass)){
                    long val = db.addUser(username,password,email,name);
                    if (val > 0){
                        Toast.makeText(registerpage.this,"You Have successfully registered",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(registerpage.this,secondpage.class);
                        startActivity(moveToLogin);
                    }
                    else{
                        Toast.makeText(registerpage.this,"Registration Error",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(registerpage.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}