package com.example.damfinalproject;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class StudentsDataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "studentsDataBase.db";
    public static final String TABLE_NAME = "student_acounts_table";
    public static final String COL_ID = "ID";
    public static final String COL_NAME = "Name";
    public static final String COL_EMAIL = "eMail";
    public static final String COL_PASSWORD = "Password";

    public StudentsDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME
                + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_NAME + " TEXT, "
                + COL_EMAIL + " TEXT, "
                + COL_PASSWORD + " TEXT " +
                "); ");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
    }
    public boolean insertData(String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, name);
        values.put(COL_EMAIL, email);
        values.put(COL_PASSWORD, password);
        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + TABLE_NAME;
        Cursor result = db.rawQuery(query,null);
        return result;
    }
    public String getPasswordForEmail(String eMail){
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            //String query = "SELECT " + COL_PASSWORD + " FROM " + TABLE_NAME + " WHERE " +
                    //COL_EMAIL + " = " + "'"+eMail +"';";
            String query = "Select * from "+TABLE_NAME;
            @SuppressLint("Recycle") Cursor result = db.rawQuery(query,null);

            if (result.getCount() == 0) {
                return "No acounts created";
            }
            while(result.moveToNext()){
                if(result.getString(2).equals(eMail)){
                    return result.getString(3);
                }
            }
            return "Nu exista un cont cu acest eMail";
        }
        catch(Exception e){
            return"Exception gets thrown";
        }
    }

}
