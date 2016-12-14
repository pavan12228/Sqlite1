package com.example.ravi.sqlite1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etEmail,etPassword;
    TextView tvLogin,tvCancel,tvNewUser;

   DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         dbHelper=new DBHelper(this);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        tvLogin = (TextView) findViewById(R.id.tvLogin);
        tvCancel = (TextView) findViewById(R.id.tvCancel);
        tvNewUser = (TextView) findViewById(R.id.tvNewUser);
        tvLogin.setOnClickListener(this);
        tvCancel.setOnClickListener(this);
        tvNewUser.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        Boolean val;
            switch (v.getId()){

           case   R.id.tvLogin:
                 String email=etEmail.getText().toString().trim();
                 String password=etPassword.getText().toString().trim();
                    val=dbHelper.logigCheck(email,password);
                      if(val){
                          startActivity(new Intent(getApplicationContext(),HomeActvity.class));
                      }
               else {
                          callToast("Login failed");

                      }

                break;
                case   R.id.tvCancel:


                    etEmail.setText("");
                    etPassword.setText("");


                    break;



                case   R.id.tvNewUser:
                    startActivity(new Intent(getApplicationContext(),NewUserActivity.class));




                    break;




            }










    }
    public void callToast(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
    }
}
