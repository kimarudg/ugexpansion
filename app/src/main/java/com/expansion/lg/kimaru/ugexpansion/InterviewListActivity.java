package com.expansion.lg.kimaru.ugexpansion;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InterviewListActivity extends AppCompatActivity {
    TextView textshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_interview);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Interview");
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_action));
        try {
            textshow= (TextView) findViewById(R.id.textShow);

            InterviewTable interviewTable =new InterviewTable(getApplicationContext());
            List<Interview> interviewList=new ArrayList<>();



            interviewList= interviewTable.getInterviewData();

            StringBuilder stringBuilder=new StringBuilder();

            for (Interview interview:interviewList) {

                stringBuilder.append(interview.getApplicant()  + "\n Total: " + interview.getTotal() + "\n\n");
            }

            textshow.setText(stringBuilder);
        }catch (Exception error){

            Toast.makeText(this, "not found any register", Toast.LENGTH_SHORT).show();
            textshow.setText("not found");
        }
    }
}
