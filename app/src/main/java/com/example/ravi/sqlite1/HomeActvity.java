package com.example.ravi.sqlite1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Ravi on 13-12-2016.
 */
public class HomeActvity extends Activity implements View.OnClickListener {
    TextView tvRetStudents,tvUpdateStudents,tvDeleteStudents,tvListStudents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        tvRetStudents       = (TextView) findViewById(R.id.tvRetStudents);
        tvUpdateStudents    = (TextView) findViewById(R.id.tvUpdateStudents);
        tvDeleteStudents    = (TextView) findViewById(R.id.tvDeleteStudents);
        tvListStudents      = (TextView) findViewById(R.id.tvListStudents);
        tvRetStudents.setOnClickListener(this);
        tvUpdateStudents.setOnClickListener(this);
        tvDeleteStudents.setOnClickListener(this);
        tvListStudents.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i=null;
        switch (v.getId())
        {
            case R.id.tvRetStudents:
                i = new Intent(getApplicationContext(),ReteriveActivity.class);
                startActivity(i);
                break;
            case R.id.tvUpdateStudents:
                i = new Intent(getApplicationContext(),UpdateActivity.class);
                startActivity(i);
                break;
            case R.id.tvDeleteStudents:
                i = new Intent(getApplicationContext(),DeleteActivity.class);
                startActivity(i);
                break;
//            case R.id.tvListStudents:
//                i = new Intent(getApplicationContext(),ListStudentsActivity.class);
//                startActivity(i);
//                break;
        }
    }













    }

