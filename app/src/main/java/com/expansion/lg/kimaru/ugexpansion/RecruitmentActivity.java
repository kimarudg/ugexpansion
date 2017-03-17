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


public class RecruitmentActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_recruitment);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("New Recruitment");
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

                Toast.makeText(this, "Validating and saving the record", Toast.LENGTH_LONG).show();
                Integer currentDate =  (int) (new Date().getTime()/1000);
                String name = mEditName.getText().toString();
                String district = mEditNumber.getText().toString();
                String subcounty = mEditMail.getText().toString();
                String division = mEditName.getText().toString();
                String lat = mEditName.getText().toString();
                String lon = mEditName.getText().toString();
                String comment = mEditName.getText().toString();
                Integer addedBy = loggedInUser;
                Integer dateAdded = currentDate;
                Integer synced = 0;

                // Do some validations
                if (name.toString().trim().equals("") || name.toString().equals("Name")){
                    Toast.makeText(this, "Name cannot be blank", Toast.LENGTH_SHORT).show();
                }

                else if (district.toString().trim().equals("")){
                    Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show();
                }

                else if(subcounty.toString().trim().equals("")){
                    Toast.makeText(this, "Phone is required", Toast.LENGTH_SHORT).show();
                }

                else {

                    // Save Registration
                    Toast.makeText(this, "Saving the Details to the Database", Toast.LENGTH_LONG).show();
//                    Registration registration = new Registration(mName, mNumber, mEmail);
                    Recruitment recruitment = new Recruitment(name, district, subcounty, division, lat, lon, comment, addedBy, dateAdded,synced);

                    RecruitmentTable recruitmentTable = new RecruitmentTable(getApplicationContext());
                    long id = recruitmentTable.addData(recruitment);

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
