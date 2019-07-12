package com.example.smartcityambiance.Event;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.smartcityambiance.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventActivity extends AppCompatActivity {



    // Array of strings for ListView Title
    String[] eventTitle = new String[]{
            "Austria Center",
            "Vienna best Clubs",
            "Disco in Vienna",
            "Christmas in Vienna",
    };

    //Foto Quellen
    //         https://www.artforart.at/events.php
    //         https://www.t-online.de/heim-garten/wohnen/id_82866632/aerger-mit-den-nachbarn-so-viel-party-ist-an-silvester-erlaubt.html
    //         https://www.1000things.at/blog/ausgefallene-event-highlights-in-wien-2019-teil-1/
    //         https://ichreise.at/allgemein/silvester-2018-wo-in-wien-die-besten-events-zum-jahreswechsel-steigen/
    //   Array List for Imagess
    int[] eventImage = new int[]{
            R.drawable.events1,
            R.drawable.event2,
            R.drawable.event3,
            R.drawable.event4,
    };

    // Array List for Description
    String[] eventShortDescription = new String[]{
            "experience cozy evening",
            "party all night, meet new people",
            "young people, hot nights",
            "wonderful place to celebrate christmas",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);


        // List<Hashmap> for add Event name imaje end description
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
       // For loop to Add 4 default Event in List
        for (int i = 0; i < 4; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", eventTitle[i]);
            hm.put("listview_discription", eventShortDescription[i]);
            hm.put("listview_image", Integer.toString(eventImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview__title, R.id.listview_description};
       //Use SimpleAdapter to add in listview Event name and descriprion and in ImageView Restourant Image
        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.text_view_for_eatlist, from, to);
        ListView search = (ListView) findViewById(R.id.event_view_id);
        search.setAdapter(simpleAdapter);

        // After click Button in Liste is opened Layout accordingly
        search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0) {
                    Intent intent = new Intent(EventActivity.this, EventFirstResultActivity.class);
                    startActivity(intent);
                } if(position == 1){
                    Intent intent = new Intent(EventActivity.this, EventSecondResultActivity.class);
                    startActivity(intent);
                }if(position == 2){
                    Intent intent = new Intent(EventActivity.this, EventThirdResultActivity.class);
                    startActivity(intent);
                }if(position == 3){
                    Intent intent = new Intent(EventActivity.this, EventFourthResultActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
