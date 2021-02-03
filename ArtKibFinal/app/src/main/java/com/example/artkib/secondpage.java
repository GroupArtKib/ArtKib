package com.example.artkib;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
                log_onClick(v);

            }
        });


        }
        public void log_onClick(View v) {
            DatabaseHelper db = new DatabaseHelper(getApplicationContext());
            String username = UserName.getEditText().getText().toString();
            String password = Password.getEditText().getText().toString();
            Account account = db.login(username, password);
            if (account == null){
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Error");
                builder.setMessage("LOG IN ERROR");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }else {
                Intent intent = new Intent(secondpage.this, mainpage.class);
                startActivity(intent);
            }

        }
    }

