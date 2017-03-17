package com.expansion.lg.kimaru.ugexpansion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RegistrationListActivity extends AppCompatActivity {
    TextView textshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_registration);
        try {
            textshow= (TextView) findViewById(R.id.textShow);

            RegistrationTable registrationTable =new RegistrationTable(getApplicationContext());
            List<Registration> registrationList=new ArrayList<>();



            registrationList= registrationTable.getRegistrationData();

            StringBuilder stringBuilder=new StringBuilder();

            for (Registration registration:registrationList) {

                stringBuilder.append(registration.getName()  + "\n" + registration.getPhone() + "\n" + registration.getGender() + "\n\n");
            }

            textshow.setText(stringBuilder);
        }catch (Exception error){

            Toast.makeText(this, "not found any register", Toast.LENGTH_SHORT).show();
            textshow.setText("not found");
        }
    }
}
