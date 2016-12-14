package com.example.ravi.sqlite1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ravi on 13-12-2016.
 */

public class DBHelper extends SQLiteOpenHelper
{
    SQLiteDatabase db = null;
    public DBHelper(Context context) {
        super(context,"ManiDB", null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table  Student(email Text Primary key,password Text,phone Text)");
    }


    public boolean logigCheck(String email,String password)
    {
        boolean val =false;
        db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Student", null);
        if (cursor.moveToFirst())
        {
            String eMail = cursor.getString(cursor.getColumnIndex("email"));
            String pwd = cursor.getString(cursor.getColumnIndex("password"));
            if (email.equals(eMail) && password.equals(pwd))
            {
                val = true;
            }
            else
                val = false;
        }
        return val;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    public long updateStudnetRecord(String email,String password,String phone)
    {
        db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password",password);
        contentValues.put("phone",phone);
        long id = db.update("Student", contentValues, "email = ?", new String[]{email});
        return id;
    }
    public long deleteRecord(String email)
    {
        db = this.getWritableDatabase();
        long id =  db.delete("Student", "email" + " = ?", new String[] { email });
        return id;
    }

    public long insertStudentRecords(String email, String password, String phone) {


        db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(email,email);
         cv.put("password",password);
         cv.put("phone",phone);
          long id=db.insert("Student",null,cv);

        return id;
    }
}