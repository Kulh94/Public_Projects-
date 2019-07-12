package com.example.smartcityambiance.Living;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.smartcityambiance.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LivingActivity extends AppCompatActivity {

    // Array of strings for Living Title
    String[] livingTitle = new String[]{
            "First District",
            "Landstraße",
            "Mariahilf",
            "Favoriten",
    };


    // Array of int for Living Foto
    // Foto Quelle https://www.stadt-wien.at/wien/wiener-bezirke.html
    int[] livingImage = new int[]{
            R.drawable.living1,
            R.drawable.living2,
            R.drawable.living3,
            R.drawable.living4,
    };

    // Array of strings for Living Description
    String[] livingShortDescription = new String[]{
            "The 1st district of Vienna is the heart of the city",
            "Historically, through its popular attractions",
            "Vienna's main shopping streets, Mariahilfer Straße.",
            "Vienna Twin Towers known.",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_living);

        // List<Hashmap> for add Living name imaje end description
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
       // For loop to Add 4 default Living in List
        for (int i = 0; i < 4; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", livingTitle[i]);
            hm.put("listview_discription", livingShortDescription[i]);
            hm.put("listview_image", Integer.toString(livingImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview__title, R.id.listview_description};
       //Use SimpleAdapter to add in listview Living name and descriprion and in ImageView Restourant Image
       SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.text_view_for_eatlist, from, to);
       ListView search = (ListView) findViewById(R.id.list_view2);
        search.setAdapter(simpleAdapter);

        // After click Button in Liste is opened Layout accordingly
        search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0) {
                    Intent intent = new Intent(LivingActivity.this, LivingFirstResultActivity.class);
                    startActivity(intent);

                } if(position == 1){
                    Intent intent = new Intent(LivingActivity.this, LivingSecondResultActivity.class);
                    startActivity(intent);
                }if(position == 2){
                    Intent intent = new Intent(LivingActivity.this, LivingThirdResultActivity.class);
                    startActivity(intent);
                }if(position == 3){
                    Intent intent = new Intent(LivingActivity.this, LivingFourthResultActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
