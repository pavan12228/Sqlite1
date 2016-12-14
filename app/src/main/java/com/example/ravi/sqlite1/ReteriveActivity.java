package com.example.ravi.sqlite1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Ravi on 13-12-2016.
 */
public class ReteriveActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etEmail,etPassword,etPhone;
    TextView tvSearch;
    LinearLayout llData;
    DBHelper dbHelper = null;
    SQLiteDatabase db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrieve_layout);
        llData = (LinearLayout) findViewById(R.id.llData);
        dbHelper=new DBHelper(getApplicationContext());
        etEmail= (EditText) findViewById(R.id.etEmail);
        etPassword= (EditText) findViewById(R.id.etPassword);
        etPhone= (EditText) findViewById(R.id.etphone);
        tvSearch= (TextView) findViewById(R.id.tvSearch);
        tvSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

          switch (v.getId()){
              case R.id.tvSearch:

                  String email = etEmail.getText().toString();
                  llData.setVisibility(View.VISIBLE);
                  db = dbHelper.getReadableDatabase();
                  Cursor cursor=db.rawQuery("select * from Student  where email='"+email+"'",null);

                      if (cursor.moveToFirst()){

                           String password = cursor.getString(cursor.getColumnIndex("password"));
                           String phone = cursor.getString(cursor.getColumnIndex("phone"));
                           etPassword.setText(password);
                          etPhone.setText(phone);
                      }



                  break;
          }






    }
}
