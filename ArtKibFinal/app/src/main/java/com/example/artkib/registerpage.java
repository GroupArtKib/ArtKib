package com.example.artkib;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
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
    TextInputLayout fname, UserName, Password, Email;
    Button reg, log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);

        fname = findViewById(R.id.name);
        UserName = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        Email = findViewById(R.id.email);
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
                reg_onClick(v);
            }
        });
    }
    public void reg_onClick(View v){
        try {
            DatabaseHelper db = new DatabaseHelper(getApplicationContext());
            Account account = new Account();

            account.setFullname(fname.getEditText().getText().toString());
            account.setUsername(UserName.getEditText().getText().toString());
            account.setEmail(Email.getEditText().getText().toString());
            account.setPassword(Password.getEditText().getText().toString());
             if (db.create(account)) {
                        Intent intent = new Intent(registerpage.this, secondpage.class);
                        startActivity(intent);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                        builder.setTitle("Error");
                        builder.setMessage("Registration Can't Complete");
                        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        builder.show();
             }
        }
        catch (Exception e){
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle("Error");
            builder.setMessage("Try Again");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
        }
    }
}