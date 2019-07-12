package com.example.smartcityambiance.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartcityambiance.MainActivity;
import com.example.smartcityambiance.R;



public class MyAccountActivity extends AppCompatActivity {
    private Button delete;

    TextView name;
    TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myaccount);

        name = (TextView) findViewById(R.id.nameid);
        email = (TextView) findViewById(R.id.emailid);

        //checking if static vraiable fname ist empty and if not setting the text for the textview
        if(RegistrationActivity.fname != "") {
            name.setText(RegistrationActivity.fname + " " + RegistrationActivity.familyname);
            email.setText(RegistrationActivity.mail);
        }


        delete = (Button) findViewById(R.id.deleteaccaountid);

        final int lengthLong = Toast.LENGTH_LONG;
        final String toast = "Your account was successfully deleted!";

        //with the click on the button delete the static variables from ReistrationActivity are set to null and thus deleted
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = (Toast) Toast.makeText(MyAccountActivity.this, toast, lengthLong);
                t.show();
                RegistrationActivity.familyname="";
                RegistrationActivity.fname="";
                RegistrationActivity.mail="";

                Intent intent = new Intent(MyAccountActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
