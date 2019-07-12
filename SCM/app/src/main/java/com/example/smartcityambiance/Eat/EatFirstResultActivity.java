package com.example.smartcityambiance.Eat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import com.example.smartcityambiance.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;


public class EatFirstResultActivity extends AppCompatActivity {

    // flag used for default at the beginning for add 4 default Objekt
    private boolean flag = true;
    private static boolean rating = true;

    //Private ImageButtons for Emojis
   private ImageButton firstEmoj;
   private ImageButton secondEmoj;
   private ImageButton thirdEmoj;
   private ImageButton fourthEmoj;

   //Private Buttons for Info gallery and feedback
   private Button info;
   private Button gallery;
   private Button feedback;
   // Use for Statistik value
    private static float firstStatistik = 25;
    private static float secondStatistik = 35;
    private static float thirdStatistik = 10;
    private static float fourthStatistik = 44;

   static String piecentertext;



    //Quelle https://www.android-examples.com/pie-chart-graph-android-app-using-mpandroidchart/
    PieChart pieChart ;
    ArrayList<Entry> entries ;
    ArrayList<String> PieEntryLabels ;
    PieDataSet pieDataSet ;
    PieData pieData ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat_first_result);

        //Quelle approximately 60% Code from -> https://www.android-examples.com/pie-chart-graph-android-app-using-mpandroidchart/

        pieChart = (PieChart) findViewById(R.id.chart1);

        pieChart.setCenterText("SCA");

        // at the beginning Add default Piechart
        if(flag) {

            //Default Statistik Values at the beginning

            // Two ArrayList, One for Statistik value and position, and second for empty STring
            entries = new ArrayList<>();
            PieEntryLabels = new ArrayList<String>();

            //Methods are called
            AddValuesToPIEENTRY();
            AddValuesToPieEntryLabels();

            //Add first entries LIst in pieDataset and then empty String und pieset in pieData
            pieDataSet = new PieDataSet(entries, "");
            pieData = new PieData(PieEntryLabels, pieDataSet);

            // pieChart Colors textsize etc.
            pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
            pieDataSet.setValueTextColor(Color.WHITE);
            pieDataSet.setValueTextSize(12f);
            pieDataSet.setSliceSpace(5f);
            pieChart.setCenterTextSize(34f);
           //pieChart.setCenterTextSizePixels(10f);

            // Set pieData in pieChart
            pieChart.setData(pieData);
            pieChart.animateY(1600);
            flag = false;

        }


        // return button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


       // 4 Emoj Buttons
       firstEmoj = (ImageButton) findViewById(R.id.smile1id);
       secondEmoj = (ImageButton) findViewById(R.id.smile2id);
       thirdEmoj = (ImageButton) findViewById(R.id.smile3id);
       fourthEmoj = (ImageButton) findViewById(R.id.smile4id);

       //Buttons for indo gallery and feedback
       info = (Button) findViewById(R.id.infoid);
       gallery = (Button) findViewById(R.id.galleryoneid);
       feedback = (Button) findViewById(R.id.feedbackfourtid);

       //String for toast
       final int lengthLong = Toast.LENGTH_LONG;
       final String toast = "Thanks for your Feedback!";


        // After click gallery button user can see restaurant
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EatFirstResultActivity.this, GalleryOneActivity.class);
                startActivity(i);
            }
        });

       // After click info button user can see info
       info.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(EatFirstResultActivity.this, InfoActivity.class);
               startActivity(i);
           }
       });

       // After click feedback button user can write a feedback and read other feedbacks from other users.
       feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(EatFirstResultActivity.this, FeedbackOneActivity.class);
                startActivity(i);
            }
        });


       //With click on this emojis the place ist rated
        firstEmoj.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {


                //checking if the place is already been rated
                if(rating){
                    rating = false;
                    Toast t = (Toast) Toast.makeText(EatFirstResultActivity.this, toast, lengthLong);
                    t.show();

                    //Here after Feedback Statistik changed +1 and saved
                    fourthStatistik += 1;
                    piecentertext = Float.toString(fourthStatistik);
                    pieChart.setCenterText(piecentertext);

                    //Method that changed Statistik pie Chart
                    changedStatistikResult();


                }
                else {

                        Toast t = (Toast) Toast.makeText(EatFirstResultActivity.this, "You already rated!", lengthLong);
                        t.show();

                    piecentertext = Float.toString(fourthStatistik);
                    pieChart.setCenterText(piecentertext);
                    changedStatistikResult();

                    }


            }
        });

        //With click on this emojis the place ist rated
        secondEmoj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //checking if the place is already been rated
                if(rating){
                    rating = false;
                    Toast t = (Toast) Toast.makeText(EatFirstResultActivity.this, toast, lengthLong);
                    t.show();

                    //Here after Feedback Statistik changed +1 and saved
                    thirdStatistik += 1;
                    piecentertext = Float.toString(thirdStatistik);
                    pieChart.setCenterText(piecentertext);
                    //Method that changed Statistik pie Chart

                    changedStatistikResult();



                }
                else {
                        Toast t = (Toast) Toast.makeText(EatFirstResultActivity.this, "You already rated!", lengthLong);
                        t.show();

                    piecentertext = Float.toString(thirdStatistik);
                    pieChart.setCenterText(piecentertext);

                    changedStatistikResult();

                    }
                }
        });

        //With click on this emojis the place ist rated
        thirdEmoj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //checking if the place is already been rated
                if(rating){
                    rating = false;
                    Toast t = (Toast) Toast.makeText(EatFirstResultActivity.this, toast, lengthLong);
                    t.show();

                    //Here after Feedback Statistik changed +1 and saved
                    secondStatistik += 1;
                    piecentertext = Float.toString(secondStatistik);
                    pieChart.setCenterText(piecentertext);

                    changedStatistikResult();


                }

                else{
                    Toast t = (Toast) Toast.makeText(EatFirstResultActivity.this, "You already rated!", lengthLong);
                    t.show();

                    piecentertext = Float.toString(secondStatistik);
                    pieChart.setCenterText(piecentertext);

                    changedStatistikResult();

                }
            }
        });

        //With click on this emojis the place ist rated
        fourthEmoj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //checking if the place is already been rated
                if(rating){
                    rating = false;
                    Toast t = (Toast) Toast.makeText(EatFirstResultActivity.this, toast, lengthLong);
                    t.show();

                    //Here after Feedback Statistik changed +1 and saved
                    firstStatistik += 1;
                    piecentertext = Float.toString(firstStatistik);
                    pieChart.setCenterText(piecentertext);
                    //Method that changed Statistik pie Chart

                    changedStatistikResult();;

                }

                else{
                    Toast t = (Toast) Toast.makeText(EatFirstResultActivity.this, "You already rated!", lengthLong);
                    t.show();

                    piecentertext = Float.toString(firstStatistik);
                    pieChart.setCenterText(piecentertext);



                    changedStatistikResult();

                }
            }
        });


    }


    //Quelle approximately 60% Code from -> https://www.android-examples.com/pie-chart-graph-android-app-using-mpandroidchart/
    //In the List added values
    public void AddValuesToPIEENTRY(){
        entries.add(new BarEntry(firstStatistik, 0));
        entries.add(new BarEntry(secondStatistik, 1));
        entries.add(new BarEntry(thirdStatistik, 2));
        entries.add(new BarEntry(fourthStatistik, 3));
    }


    //Quelle approximately 60% Code from -> https://www.android-examples.com/pie-chart-graph-android-app-using-mpandroidchart/
    // In the List added empty Strings
    public void AddValuesToPieEntryLabels(){
        PieEntryLabels.add("");
        PieEntryLabels.add("");
        PieEntryLabels.add("");
        PieEntryLabels.add("");
    }





    public void changedStatistikResult(){
        entries = new ArrayList<>();
        PieEntryLabels = new ArrayList<String>();
        AddValuesToPIEENTRY();
        AddValuesToPieEntryLabels();
        pieDataSet = new PieDataSet(entries, "");
        pieData = new PieData(PieEntryLabels, pieDataSet);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.WHITE);
        pieDataSet.setValueTextSize(12f);
        pieDataSet.setSliceSpace(5f);
        pieChart.setCenterTextSize(34f);
       // pieChart.setCenterTextSizePixels(10f);
        pieChart.setData(pieData);
        pieChart.animateY(1600);
    }

}
