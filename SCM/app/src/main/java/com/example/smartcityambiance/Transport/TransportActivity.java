package com.example.smartcityambiance.Transport;

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

public class TransportActivity extends AppCompatActivity {


    // Array of strings for Transport Title
    String[] transportTitle = new String[]{
            "Main Station",
            "Bus",
            "Tram",
            "Westbahn",
    };

    // Array of int for Transport Images
    // Foto Quelle https://www.stadt-wien.at/wien/oeffentliche-verkehrsmittel-in-wien.html
    int[] transportImage = new int[]{
            R.drawable.transport1,
            R.drawable.transport2,
            R.drawable.transport3,
            R.drawable.transport4,
    };

    // Array of strings for Transpor description
    String[] transportShortDescription = new String[]{
            "Federal Railways operated rapid transit system",
            "The bus schedule to all bus lines! ",
            "There are 29 tram lines throughout Vienna!",
            "Travel in Austria",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        // List<Hashmap> for add Transport name imaje end description
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        // For loop to Add 4 default Transport in List
        for (int i = 0; i < 4; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", transportTitle[i]);
            hm.put("listview_discription", transportShortDescription[i]);
            hm.put("listview_image", Integer.toString(transportImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview__title, R.id.listview_description};
        //Use SimpleAdapter to add in listview Transport name and descriprion and in ImageView Transport Image
        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.text_view_for_eatlist, from, to);
        ListView search = (ListView) findViewById(R.id.transport_view);
        search.setAdapter(simpleAdapter);

        // After click Button in Liste is opened Layout accordingly
        search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0) {
                    Intent intent = new Intent(TransportActivity.this, TransportFirstResultActivity.class);
                    startActivity(intent);
                } if(position == 1){
                    Intent intent = new Intent(TransportActivity.this, TransportSecondResultActivity.class);
                    startActivity(intent);
                }if(position == 2){
                    Intent intent = new Intent(TransportActivity.this, TransportThirdResultActivity.class);
                    startActivity(intent);
                }if(position == 3){
                    Intent intent = new Intent(TransportActivity.this, TransportFourthResultActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
