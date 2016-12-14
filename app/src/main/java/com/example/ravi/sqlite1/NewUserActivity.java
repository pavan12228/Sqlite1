package com.example.ravi.sqlite1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ravi on 13-12-2016.
 */
public class NewUserActivity  extends AppCompatActivity implements View.OnClickListener {


    EditText etEmail,etPassword,etPhone;
    TextView tvSignUp,tvCancel;
    DBHelper dbHelper=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPhone = (EditText) findViewById(R.id.etphone);
        tvSignUp = (TextView) findViewById(R.id.tvSignUp);
        tvCancel = (TextView) findViewById(R.id.tvCancel);
        tvSignUp.setOnClickListener(this);
        tvCancel.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

                switch (v.getId()){

                    case R.id.tvSignUp:


                        String email = etEmail.getText().toString().trim();
                        String password = etPassword.getText().toString().trim();
                        String phone = etPhone.getText().toString().trim();

                               long  id = dbHelper.insertStudentRecords(email,password,phone);


                                if(id!=-1){

                                   startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                }
                                else {
                                    callToast("signup failed");
                                }




                        break;
                    case R.id.tvCancel:

                      etEmail.setText("");
                      etPassword.setText("");
                      etPhone.setText("");



                        break;
                }

    }
    public void callToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }

}
