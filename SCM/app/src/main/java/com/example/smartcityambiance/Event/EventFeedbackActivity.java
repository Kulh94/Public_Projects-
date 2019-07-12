package com.example.smartcityambiance.Event;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.smartcityambiance.Navigation.RegistrationActivity;
import com.example.smartcityambiance.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EventFeedbackActivity extends AppCompatActivity {

    //Sumbit variable, List for saving user mean and TexInputEditTex for text input
    private Button sumbit;
    private static boolean isAdded = false; // check if fesdback add
    public static List<String> listUserMean = new ArrayList<>();
    public static List<String> listUserName = new ArrayList<>();

    static String username;

    TextInputEditText result;



    //Array to save User Image
    int[] userImage = new int[]{
            //source user_icon: https://icons8.com/icons/set/user-neutral
            R.drawable.user_icon,
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


            // Add defaul 4 User name and mean, Add once only
        if(!isAdded){
            listUserName.add("John Lennon");
            listUserName.add("Paul McCartney");
            listUserName.add("George Harrison");
            listUserName.add("Ringo Starr");
            listUserName.add("Hugo Smith");

            // text source: http://pun.me/pages/
            listUserMean.add("The elevator to success is out of order. You’ll have to use the stairs");
            listUserMean.add("The more you weight the harder you are to kidnap. Stay safe, eat cake.");
            listUserMean.add("If you’re not supposed to eat at night, why is there a light bulb in the refrigerator?");
            listUserMean.add("Last night at dinner we had some fish, and though I tried, I did not finish. My mother told me while I chewed, brains loved fish over all other food.");
            listUserMean.add("My wallet is like an onion. When I open it, it makes me cry...");
            isAdded = true;
        }


            //Text thet user whant to post in feedback
            result = (TextInputEditText) findViewById(R.id.textfedbackid);


            //Sumbit Button for saving user mean
            sumbit = (Button) findViewById(R.id.saveregisterbutton);

            //for message wenn user saved feedback
            final int lengthLong = Toast.LENGTH_LONG;
            final String toast = "Thanks for your Feedback!";


           if(RegistrationActivity.fname.isEmpty()){
                username = "unknown user";
            }
            else{
              username = RegistrationActivity.fname + " " + RegistrationActivity.familyname;
            }

            //after click sumbit user gets Info that feedback saved , message is saved in list and Intent for refresh Layout
            sumbit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (result.getText().toString().isEmpty()) {
                        Toast toast1 = (Toast) Toast.makeText(EventFeedbackActivity.this, "Please type a feedback first!", lengthLong);
                        toast1.show();

                    }
                    else {
                        Toast t = (Toast) Toast.makeText(EventFeedbackActivity.this, toast, lengthLong);
                        t.show();
                        listUserMean.add(result.getText().toString());
                        listUserName.add(username);
                        Intent intent = new Intent(EventFeedbackActivity.this, EventFeedbackActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });


            // List  to save Foto , name and mean from user
            List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

            // Foto name and mean in Map add and then at the and in List
            for (int i = listUserMean.size()-1; i >= 0; i--) {
                HashMap<String, String> hm = new HashMap<String, String>();
                hm.put("listview_title", listUserName.get(i));
                hm.put("listview_discription", listUserMean.get(i));
                hm.put("listview_image", Integer.toString(userImage[0]));
                aList.add(hm);
            }

            //From where in where add all
            String[] from = {"listview_image", "listview_title", "listview_discription"};
            int[] to = {R.id.listview_image, R.id.listview__title, R.id.listview_description};

            //text_view_for_eatlist is our Shablon that add in ListView in every singel line Foto , name and mean from User
            SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.text_view_for_eatlist, from, to);
            ListView search = (ListView) findViewById(R.id.listfeedbackid);
            search.setAdapter(simpleAdapter);



    }
}
