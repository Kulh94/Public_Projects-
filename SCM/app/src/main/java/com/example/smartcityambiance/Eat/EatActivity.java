package com.example.smartcityambiance.Eat;
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

public class EatActivity extends AppCompatActivity {

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

    // Array of strings for Restourant name
    String[] restourantTitle = new String[]{
            "The Italians",
            "Irish Pub",
            "American Burger",
            "Austrian Food",
    };

    // Array of int for Restourant image
    // Foto Quelle
    //   https://www.quandoo.at/place/zum-leupold-10562
    //https://www.eater.com/2017/3/7/14839472/irish-pub-design
    // https://www.tripadvisor.de/Restaurant_Review-g187773-d3785105-Reviews-Canterville_Irish_Pub-Potenza_Province_of_Potenza_Basilicata.html#photos;aggregationId=&albumid=101&filter=7&ff=251567237

    int[] restourantImage = new int[]{
            R.drawable.italians,
            R.drawable.irish_pub,
            R.drawable.american,
            R.drawable.austrian,
    };

    // Array of strings for Restourant Description
    String[] restourantDescription = new String[]{
            "Eat Italian in Vienna like the Italians in Italy..",
            "Drink, Eat, Smoke",
            "Burgers from USA",
            "Austrian speciality",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat);


        // List<Hashmap> for add Restorant name imaje end description
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        // For Loop to Add 4 default Restourant in List
        for (int i = 0; i < 4; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", restourantTitle[i]);
            hm.put("listview_discription", restourantDescription[i]);
            hm.put("listview_image", Integer.toString(restourantImage[i]));
            aList.add(hm);
        }

        //Use SimpleAdapter to add in listview restouran name and descriprion and in ImageView Restourant Image
        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview__title, R.id.listview_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.text_view_for_eatlist, from, to);
        ListView search = (ListView) findViewById(R.id.list_view);
        search.setAdapter(simpleAdapter);

        // After click Button in Liste is opened Layout accordingly
        search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0) {
                    Intent intent = new Intent(EatActivity.this, EatFirstResultActivity.class);
                    startActivity(intent);
                } if(position == 1){
                    Intent intent = new Intent(EatActivity.this, EatSecondResultActivity.class);
                    startActivity(intent);
                }if(position == 2){
                    Intent intent = new Intent(EatActivity.this, EatThirdResultActivity.class);
                    startActivity(intent);
                }if(position == 3){
                    Intent intent = new Intent(EatActivity.this, EatFourthResultActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
