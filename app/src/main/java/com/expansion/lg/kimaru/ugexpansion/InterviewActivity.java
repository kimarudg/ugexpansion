package com.expansion.lg.kimaru.ugexpansion;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class InterviewActivity extends AppCompatActivity {

    Integer loggedInUser = 1;

    EditText mEditName, mEditNumber, mEditMail, mDateMoved;
    Button buttonSave, buttonList;
    SimpleDateFormat dateFormatter;
    DatePicker date_picker;
    static final int DATE_DIALOG_ID = 100;

    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interview);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Interview");
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_action));



        // Declare Form Items here
        mEditName = (EditText) findViewById(R.id.editName);
        mEditNumber = (EditText) findViewById(R.id.editPhone);
        mEditMail = (EditText) findViewById(R.id.editMail);

        mDateMoved = (EditText) findViewById(R.id.etxt_fromdate);



        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

//        findViewsById();
//
        setCurrentDate();


        // Add methods here
        addListenerOnButton();
    }

    public void addListenerOnButton(){
        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonList = (Button) findViewById(R.id.buttonList);


        buttonSave.setOnClickListener( new OnClickListener(){

            @Override
            public void onClick(View view){
                clickOnButton(view);
            }
        });
        buttonList.setOnClickListener( new OnClickListener(){

            @Override
            public void onClick(View view){
                clickOnButton(view);
            }
        });

        mDateMoved = (EditText) findViewById(R.id.etxt_fromdate);

        mDateMoved.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                showDialog(DATE_DIALOG_ID);

            }

        });
    }

    public void clickOnButton(View view){
        switch (view.getId()){
            case R.id.buttonSave:
                // applicant, recruitment, motivation, community, mentality, selling, health, investment, interpersonal, commitment, total, selected, addedBy, dateAdded, synced
                Toast.makeText(this, "Validating and saving the record", Toast.LENGTH_LONG).show();
                Integer currentDate =  (int) (new Date().getTime()/1000);
                Integer applicant = Integer.parseInt(mEditName.getText().toString());
                Integer recruitment = Integer.parseInt(mEditNumber.getText().toString());
                Integer motivation = Integer.parseInt(mEditMail.getText().toString());
                Integer community = Integer.parseInt(mEditName.getText().toString());
                Integer mentality = Integer.parseInt(mEditName.getText().toString());
                Integer selling = Integer.parseInt(mEditName.getText().toString());
                Integer health = Integer.parseInt(mEditName.getText().toString());
                Integer investment = Integer.parseInt(mEditName.getText().toString());
                Integer interpersonal = Integer.parseInt(mEditName.getText().toString());
                Integer commitment = Integer.parseInt(mEditName.getText().toString());
                Integer total = Integer.parseInt(mEditName.getText().toString());
                Integer selected = Integer.parseInt(mEditName.getText().toString());
                String comment = mEditName.getText().toString();
                Integer addedBy = loggedInUser;
                Integer dateAdded = currentDate;
                Integer synced = 0;

                // Do some validations
                if (applicant.toString().trim().equals("") || applicant.toString().equals("Name")){
                    Toast.makeText(this, "Name cannot be blank", Toast.LENGTH_SHORT).show();
                }

                else if(recruitment.toString().trim().equals("")){
                    Toast.makeText(this, "Phone is required", Toast.LENGTH_SHORT).show();
                }

                else {

                    // Save Registration
                    Toast.makeText(this, "Saving the Details to the Database", Toast.LENGTH_SHORT).show();
//                    Integer applicant, Integer recruitment, Integer motivation, Integer community,
//                            Integer mentality, Integer selling, Integer health, Integer investment,
//                            Integer interpersonal, Integer commitment, Integer selected, Integer addedBy,
//                            Integer dateAdded, Integer synced, String comment
                    Interview interview = new Interview(applicant, recruitment, motivation, community,
                            mentality, selling, health, investment, interpersonal, commitment, selected,
                            addedBy, dateAdded, synced, comment);

                    InterviewTable interviewTable = new InterviewTable(getApplicationContext());
                    long id = interviewTable.addData(interview);

                    if (id ==-1){
                        Toast.makeText(this, "Could not save registration", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this, "Saved successfully", Toast.LENGTH_SHORT).show();

                        // Clear boxes
                        mEditName.setText("");
                        mEditNumber.setText("");
                        mEditMail.setText("");
                    }

                }
                break;
            case R.id.buttonList:
                Intent intent = new Intent(getApplicationContext(), RegistrationListActivity.class);
                startActivity(intent);
                break;

        }
    }

    // display current date both on the text view and the Date Picker when the application starts.
    public void setCurrentDate() {

        mDateMoved = (EditText) findViewById(R.id.etxt_fromdate);
        date_picker = (DatePicker) findViewById(R.id.date_picker);

        final Calendar calendar = Calendar.getInstance();

        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);

        // set current date into textview
        mDateMoved.setText(new StringBuilder()
                // Month is 0 based, so you have to add 1
                .append(mMonth + 1).append("-")
                .append(mDay).append("-")
                .append(mYear).append(" "));

        // set current date into Date Picker
        date_picker.init(mYear, mMonth, mDay, null);

    }
    @Override
    protected Dialog onCreateDialog(int id) {

        switch (id) {
            case DATE_DIALOG_ID:
                // set date picker as current date
                return new DatePickerDialog(this, datePickerListener, mYear, mMonth,mDay);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,int selectedMonth, int selectedDay) {
            mYear = selectedYear;
            mMonth = selectedMonth;
            mDay = selectedDay;

            // set selected date into Text View
            mDateMoved.setText(new StringBuilder().append(mMonth + 1)
                    .append("-").append(mDay).append("-").append(mYear).append(" "));

            // set selected date into Date Picker
            date_picker.init(mYear, mMonth, mDay, null);
        }
    };
}
