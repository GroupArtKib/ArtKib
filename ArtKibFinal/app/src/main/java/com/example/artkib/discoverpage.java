package com.example.artkib;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class discoverpage extends AppCompatActivity {

    GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discoverpage);

        //START NAVIGATION
        BottomNavigationView bottomNavigationView = findViewById(R.id.BottomNavigationView);

        bottomNavigationView.setSelectedItemId(R.id.discover);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.discover:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), mainpage.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), profilepage.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        }); //END NAVIGATION

        //Start GridLayout
        gridLayout= findViewById(R.id.gridLayout);

        setSingleEvent(gridLayout);
    }

    private void setSingleEvent(GridLayout gridLayout) {
        for (int i=0; i<gridLayout.getChildCount(); i++){

            CardView cardview = (CardView)gridLayout.getChildAt(i);
            final int finalI= i;
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(finalI==0) {
                        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=Arts+and+Crafts+"));
                        startActivity(intent);
                    }
                    else if(finalI==1) {
                        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=Life+Hacks+"));
                        startActivity(intent);
                    }
                    else if(finalI==2) {
                        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=Beauty+and+Health+Hacks+"));
                        startActivity(intent);
                    }
                    else if(finalI==3) {
                        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=Home+Decoration+Hacks+"));
                        startActivity(intent);
                    }
                    else if(finalI==4) {
                        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=Food+Hacks+"));
                        startActivity(intent);
                    }
                    else if(finalI==5) {
                        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=Fashion+Hacks+"));
                        startActivity(intent);
                    }
                    else if(finalI==6){
                        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=Gardening+Hacks+"));
                        startActivity(intent);
                    }
                    else if(finalI==7) {
                        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=DIY+Hacks+"));
                        startActivity(intent);
                    }

                }
            });
        }

    } //End GridLayout
}