package com.expansion.lg.kimaru.ugexpansion;

import android.app.DatePickerDialog;
import android.app.Dialog;
//import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import android.support.v4.app.Fragment;

import com.expansion.lg.kimaru.ugexpansion.R;


public class ExamActivity extends Fragment {

    public Integer loggedInUser = 1;
    EditText mEditName, mEditNumber, mEditMail, mDateMoved;
    Button buttonSave, buttonList;
    SimpleDateFormat dateFormatter;
    DatePicker date_picker;
    static final int DATE_DIALOG_ID = 100;
    private int mYear, mMonth, mDay, mHour, mMinute;


    //LoggedInUser
    private String mParam1;
    private Integer user;

    private OnFragmentInteractionListener mListener;


    public ExamActivity() {
        //required empty constructor
    }

    public static ExamActivity newInstance (Integer loggedInUser, String param2){
        ExamActivity fragment = new ExamActivity();
        Bundle args = new Bundle();
        args.putInt("ARG1", loggedInUser);
        args.putString("ARG2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    //================

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            user = getArguments().getInt("ARG1");
            mParam1 = getArguments().getString("ARG2");
        }
//
//        setContentView(R.layout.activity_exam);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("Exam");
//        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.background_action));



        // Declare Form Items here
//        mEditName = (EditText) findViewById(R.id.editName);
//        mEditNumber = (EditText) findViewById(R.id.editPhone);
//        mEditMail = (EditText) findViewById(R.id.editMail);
//
//        mDateMoved = (EditText) findViewById(R.id.etxt_fromdate);
//
//
//
//        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
//
////        findViewsById();
////
//        setCurrentDate();
//
//
//        // Add methods here
//        addListenerOnButton();
    }

//    public void addListenerOnButton(){
//        buttonSave = (Button) findViewById(R.id.buttonSave);
//        buttonList = (Button) findViewById(R.id.buttonList);
//
//
//        buttonSave.setOnClickListener( new OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//                clickOnButton(view);
//            }
//        });
//        buttonList.setOnClickListener( new OnClickListener(){
//
//            @Override
//            public void onClick(View view){
//                clickOnButton(view);
//            }
//        });
//
//        mDateMoved = (EditText) findViewById(R.id.etxt_fromdate);
//
//        mDateMoved.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                showDialog(DATE_DIALOG_ID);
//
//            }
//
//        });
//    }

//    public void clickOnButton(View view){
//        switch (view.getId()){
//            case R.id.buttonSave:
//                // applicant, recruitment, math, english, personality, addedBy, dateAdded, synced
//                Toast.makeText(this, "Validating and saving the record", Toast.LENGTH_LONG).show();
//                Integer currentDate =  (int) (new Date().getTime()/1000);
//                Integer applicant = Integer.parseInt(mEditName.getText().toString());
//                Integer recruitment = Integer.parseInt(mEditNumber.getText().toString());
//                Integer math = Integer.parseInt(mEditMail.getText().toString());
//                Integer english = Integer.parseInt(mEditName.getText().toString());
//                Integer personality = Integer.parseInt(mEditName.getText().toString());
//                String comment = mEditName.getText().toString();
//                Integer addedBy = loggedInUser;
//                Integer dateAdded = currentDate;
//                Integer synced = 0;
//
//                // Do some validations
//                if (applicant.toString().trim().equals("") || applicant.toString().equals("Name")){
//                    Toast.makeText(this, "Name cannot be blank", Toast.LENGTH_SHORT).show();
//                }
//
//                else if(recruitment.toString().trim().equals("")){
//                    Toast.makeText(this, "Phone is required", Toast.LENGTH_SHORT).show();
//                }
//
//                else {
//
//                    // Save Registration
//                    Toast.makeText(this, "Saving the Details to the Database", Toast.LENGTH_LONG).show();
////                    Integer applicant, Integer math, Integer recruitment, Integer personality,
//                    // Integer english, Integer addedBy, Integer dateAdded, Integer synced, String comment
//                    Exam exam = new Exam(applicant, math, recruitment, personality, english, addedBy, dateAdded, synced, comment);
//
//                    ExamTable examTable = new ExamTable(getApplicationContext());
//                    long id = examTable.addData(exam);
//
//                    if (id ==-1){
//                        Toast.makeText(this, "Could not save registration", Toast.LENGTH_SHORT).show();
//                    }
//                    else{
//                        Toast.makeText(this, "Saved successfully", Toast.LENGTH_SHORT).show();
//
//                        // Clear boxes
//                        mEditName.setText("");
//                        mEditNumber.setText("");
//                        mEditMail.setText("");
//                    }
//
//                }
//                break;
//            case R.id.buttonList:
//                Intent intent = new Intent(getApplicationContext(), RegistrationListActivity.class);
//                startActivity(intent);
//                break;
//
//        }
//    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_exam, container, false);
    }

    public void onButtonPressed(Uri uri){
        if (mListener != null){
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
    }

    public void onDetach(){
        super.onDetach();
        mListener = null;
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
