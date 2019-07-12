package com.example.smartcityambiance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;
import com.example.smartcityambiance.Eat.EatActivity;
import com.example.smartcityambiance.Eat.EatFirstResultActivity;
import com.example.smartcityambiance.Event.EventActivity;
import com.example.smartcityambiance.Event.EventFirstResultActivity;
import com.example.smartcityambiance.Living.LivingActivity;
import com.example.smartcityambiance.Living.LivingFirstResultActivity;
import com.example.smartcityambiance.Navigation.FeedbackActivity;
import com.example.smartcityambiance.Navigation.MyAccountActivity;
import com.example.smartcityambiance.Navigation.RegistrationActivity;
import com.example.smartcityambiance.Navigation.VersionActivity;
import com.example.smartcityambiance.Transport.TransportActivity;
import com.example.smartcityambiance.Transport.TransportFirstResultActivity;




public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Private Variable for ImageButtons
    static String querey;
    private ImageButton eat;
    private ImageButton transport;
    private ImageButton event;
    private ImageButton livingplace;
    private SearchView search;





    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        search = (SearchView) findViewById(R.id.searchView);

        //starting activities with intent after getting the input witch initializes the querey variable,
        // to compare the querey with hardcoded examples and thus start the aimed activity
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String input) {
                querey = input;
                if(querey.equals("the italian") || querey.equals("good restaurant") || querey.equals("italian food")){
                    Intent i = new Intent(MainActivity.this, EatFirstResultActivity.class);
                    startActivity(i);
                }

                else if(querey.equals("party") || querey.equals("big events") || querey.equals("meet people")){
                    Intent i = new Intent(MainActivity.this, EventActivity.class);
                    startActivity(i);
                }

                else if(querey.equals("oebb") || querey.equals("main station") || querey.equals("südtiroler platz")){
                    Intent i = new Intent(MainActivity.this, TransportFirstResultActivity.class);
                    startActivity(i);
                }

                else if(querey.equals("nice places to live") || querey.equals("vienna city living") || querey.equals("sight seeing")){
                    Intent i = new Intent(MainActivity.this, LivingActivity.class);
                    startActivity(i);
                }

                else if(querey.equals("first vienna") || querey.equals("stephansplatz") || querey.equals("nice place")){
                    Intent i = new Intent(MainActivity.this, LivingFirstResultActivity.class);
                    startActivity(i);
                }

                else if(querey.equals("good restaurants") || querey.equals("bars") || querey.equals("good food")){
                    Intent i = new Intent(MainActivity.this, EatActivity.class);
                    startActivity(i);
                }

                else if(querey.equals("cozy evening") || querey.equals("austria center")){
                    Intent i = new Intent(MainActivity.this, EventFirstResultActivity.class);
                    startActivity(i);
                }

                else if(querey.equals("train") || querey.equals("international transport") || querey.equals("public transport")){
                    Intent i = new Intent(MainActivity.this, TransportActivity.class);
                    startActivity(i);
                }

                else{
                    Toast toast = (Toast) Toast.makeText(MainActivity.this,"Please try again! Search hint: 'italian food'", Toast.LENGTH_LONG);
                    toast.show();
                }
                return true;
            }

            @Override
            public boolean onQueryTextChange(String input) {

                return true;
            }
        });


        eat = (ImageButton) findViewById(R.id.eatbuttonid);
        transport = (ImageButton) findViewById(R.id.transportid);
        event = (ImageButton) findViewById(R.id.eventid);
        livingplace = (ImageButton) findViewById(R.id.livingid) ;



        // after click Event Button created Event Activity
        event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, EventActivity.class);
                startActivity(i);
            }
        });

        // after click transport Button created Transport Activity
        transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TransportActivity.class);
                startActivity(i);
            }
        });
        // after click Eat Button created Food Activity
        eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, EatActivity.class);
                startActivity(i);
            }
        });
        // after click Living Button created Living Activity
        livingplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LivingActivity.class);
                startActivity(i);
            }
        });


    }

   //defining default navigation menu

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.version) {
            Intent intent =  new Intent(MainActivity.this, VersionActivity.class);
            startActivity(intent);

        } else if (id == R.id.feedback_send) {
            Intent intent =  new Intent(MainActivity.this, FeedbackActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.myaccount) {
            Intent intent =  new Intent(MainActivity.this, MyAccountActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.registrationId) {
            Intent intent =  new Intent(MainActivity.this, RegistrationActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
