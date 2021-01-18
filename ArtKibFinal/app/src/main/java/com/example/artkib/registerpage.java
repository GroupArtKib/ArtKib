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

public class registerpage extends AppCompatActivity {
    DatabaseHelper db;
    EditText username1;
    EditText password1;
    EditText confirmpass1;
    Button register;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);
        db=new DatabaseHelper(this);

        username1 = (EditText)findViewById(R.id.username1);
        password1 = (EditText)findViewById(R.id.editTextTextEmailAddress);
        confirmpass1 =(EditText)findViewById(R.id.confirmpass);
        register = (Button)findViewById(R.id.button3);
        login = (TextView)findViewById(R.id.login2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(registerpage.this,MainActivity.class);
                startActivity(LoginIntent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= username1.getText().toString();
                String password= password1.getText().toString();
                String confirmpass= confirmpass1.getText().toString();

                if (password.equals(confirmpass)){
                    long val = db.addUser(username,password);
                    if (val > 0){
                        Toast.makeText(registerpage.this,"You Have successfully registered",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(registerpage.this,MainActivity.class);
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