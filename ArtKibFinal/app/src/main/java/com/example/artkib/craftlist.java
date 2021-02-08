package com.example.artkib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class craftlist extends AppCompatActivity {

    GridView gridView;
    ArrayList<Craft> list;
    CarftListAdapter adapter = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_craftlist);

        //START NAVIGATION
        BottomNavigationView bottomNavigationView = findViewById(R.id.BottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        return true;
                    case R.id.discover:
                        startActivity(new Intent(getApplicationContext(), discoverpage.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), profilepage.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        }); //END NAVIGATION

        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new CarftListAdapter(this, R.layout.craft_items, list);
        gridView.setAdapter(adapter);

        // get all data from sqlite
        Cursor cursor = mainpage.sqLiteHelper.getData("SELECT * FROM IMAGE");
        list.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String caption = cursor.getString(2);
            byte[] image = cursor.getBlob(3);

            list.add(new Craft(id, name, caption, image));
        }
        adapter.notifyDataSetChanged();
    }
}