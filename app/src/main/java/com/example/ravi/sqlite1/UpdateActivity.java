package com.example.ravi.sqlite1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ravi on 13-12-2016.
 */
public class UpdateActivity  extends Activity implements View.OnClickListener {
    EditText etEmail,etPassword,etPhone;
    TextView tvSearch,tvUpdate;
    LinearLayout llData;
    DBHelper dbHelper = null;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_layout);
        dbHelper = new DBHelper(getApplicationContext());
        llData = (LinearLayout) findViewById(R.id.llData);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPhone = (EditText) findViewById(R.id.etphone);
        tvSearch = (TextView) findViewById(R.id.tvSearch);
        tvUpdate = (TextView) findViewById(R.id.tvUpdate);
        tvUpdate.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.tvSearch:
                String email = etEmail.getText().toString();
                llData.setVisibility(View.VISIBLE);
                db = dbHelper.getReadableDatabase();
                Cursor cursor = db.rawQuery("select * from Student where email='"+email+"'",null);
                if (cursor.moveToFirst())
                {
                    String password = cursor.getString(cursor.getColumnIndex("password"));
                    String phone = cursor.getString(cursor.getColumnIndex("phone"));
                    etPassword.setText(password);
                    etPhone.setText(phone);
                }
                break;

            case R.id.tvUpdate:
                String emails = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String phone = etPhone.getText().toString();
                long id = dbHelper.updateStudnetRecord(emails,password,phone);
                if (id!=-1)
                {
                    Intent i = new Intent(getApplicationContext(),HomeActvity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Record not Updated",Toast.LENGTH_SHORT).show();
                }
                break;
        }














    }
}
