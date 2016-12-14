package com.example.ravi.sqlite1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ravi on 13-12-2016.
 */
public class DeleteActivity extends Activity implements View.OnClickListener

{
    String email;
    TextView tvDelete;
    EditText etEmail;
    DBHelper dbHelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_layout);
        dbHelper = new DBHelper(getApplicationContext());
        etEmail = (EditText) findViewById(R.id.etEmail);
        tvDelete = (TextView) findViewById(R.id.tvDelete);
        tvDelete.setOnClickListener(this);








    }

    @Override
    public void onClick(View v) {



        email = etEmail.getText().toString();
        long id = dbHelper.deleteRecord(email);
        if (id!=-1)
        {
            Intent i = new Intent(getApplicationContext(),HomeActvity.class);
            startActivity(i);
        }
        else
            Toast.makeText(getApplicationContext(),"Record Not Deleted",Toast.LENGTH_SHORT).show();

    }








    }








