package com.expansion.lg.kimaru.ugexpansion;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ExamListActivity extends AppCompatActivity {
    TextView textshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_exam);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Exam");
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_action));
        try {
            textshow= (TextView) findViewById(R.id.textShow);

            ExamTable examTable =new ExamTable(getApplicationContext());
            List<Exam> examList=new ArrayList<>();



            examList= examTable.getExamData();

            StringBuilder stringBuilder=new StringBuilder();

            for (Exam exam:examList) {

                stringBuilder.append(exam.getComment()  + "\n" + exam.getDateAdded() + "\n\n");
            }

            textshow.setText(stringBuilder);
        }catch (Exception error){

            Toast.makeText(this, "not found any register", Toast.LENGTH_SHORT).show();
            textshow.setText("not found");
        }
    }
}
