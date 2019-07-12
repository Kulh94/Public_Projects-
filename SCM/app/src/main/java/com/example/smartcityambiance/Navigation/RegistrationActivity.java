package com.example.smartcityambiance.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.smartcityambiance.MainActivity;
import com.example.smartcityambiance.R;

public class RegistrationActivity extends AppCompatActivity {

    //Sumbit variable, List for saving user mean and TexInputEditTex for text input
    private Button sumbit;

    public static String fname="";
    public static String familyname;
    public static String mail;

    TextInputEditText firstname;
    TextInputEditText lastname;
    TextInputEditText email;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Text thet user whant to post in feedback
        firstname = (TextInputEditText) findViewById(R.id.nameid);
        lastname = (TextInputEditText) findViewById(R.id.lastnameid);
        email = (TextInputEditText) findViewById(R.id.emailid);


        //Sumbit Button for saving user mean
        sumbit = (Button) findViewById(R.id.saveregisterbutton);

        //for message wenn user saved feedback
        final int lengthLong = Toast.LENGTH_LONG;
        final String toast = "Thanks for your Registration!";


        //after click sumbit user gets Info that feedback saved , message is saved in list and Intent for refresh Layout
        sumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(firstname.getText().toString().isEmpty()){
                    Toast t = (Toast) Toast.makeText(RegistrationActivity.this,"Please enter your firstname!", lengthLong);
                    t.show();
                }
                else if(lastname.getText().toString().isEmpty()){
                    Toast t = (Toast) Toast.makeText(RegistrationActivity.this,"Please enter your lastname!", lengthLong);
                    t.show();
                }
                else if(email.getText().toString().isEmpty()){
                    Toast t = (Toast) Toast.makeText(RegistrationActivity.this,"Please enter your email!", lengthLong);
                    t.show();
                }
                else {
                    fname = firstname.getText().toString();
                    familyname = lastname.getText().toString();
                    mail = email.getText().toString();

                        Toast t = (Toast) Toast.makeText(RegistrationActivity.this, toast, lengthLong);
                        t.show();
                        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
        });

    }
}
