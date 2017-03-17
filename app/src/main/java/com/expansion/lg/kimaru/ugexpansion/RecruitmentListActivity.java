package com.expansion.lg.kimaru.ugexpansion;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecruitmentListActivity extends AppCompatActivity {
    TextView textshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_recruitment);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Recruitments");
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_action));
        try {
            textshow= (TextView) findViewById(R.id.textShow);

            RecruitmentTable recruitmentTable =new RecruitmentTable(getApplicationContext());
            List<Recruitment> recruitmentList=new ArrayList<>();



            recruitmentList= recruitmentTable.getRecruitmentData();

            StringBuilder stringBuilder=new StringBuilder();

            for (Recruitment recruitment:recruitmentList) {

                stringBuilder.append(recruitment.getName()  + "\n" + recruitment.getDateAdded() + "\n\n");
            }

            textshow.setText(stringBuilder);
        }catch (Exception error){

            Toast.makeText(this, "not found any register", Toast.LENGTH_SHORT).show();
            textshow.setText("not found");
        }
    }
}
