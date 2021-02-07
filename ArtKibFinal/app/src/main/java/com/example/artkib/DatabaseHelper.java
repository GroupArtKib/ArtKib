package com.example.artkib;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ArtKib.db";
    public static final String TABLE_NAME = "ArtKib";
    public static final String COL_1 = "id";
    public static final String COL_2 = "name";
    public static final String COL_3 = "username";
    public static final String COL_4 = "email";
    public static final String COL_5 = "password";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY autoincrement, name TEXT, username TEXT, email TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int il) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //public boolean addUser(String name, String username, String email, String password){
    //  SQLiteDatabase db = this.getWritableDatabase();
    //ContentValues contentValues = new ContentValues();
    // contentValues.put("name",name);
    // contentValues.put("username",username);
    // contentValues.put("email",email);
    // contentValues.put("password",password);
    // long res = db.insert("ArtKib",null,contentValues);
    // if (res == -1)
    //    return false;
    // else
    //    return true;}

    //public boolean checkUser(String username, String password){
    //   SQLiteDatabase db = getReadableDatabase();
    //  Cursor cursor = db.rawQuery("Select * from ArtKib where username = ? and password = ?", new String[]{username,password});
    // if(cursor.getCount()>0)
    //    return  true;
    // else
    //    return  false;}

    public boolean create(com.example.artkib.Account account) {
        boolean result = true;
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", account.getFullname());
            contentValues.put("username", account.getUsername());
            contentValues.put("email", account.getEmail());
            contentValues.put("password", account.getPassword());
            result = db.insert("ArtKib", null, contentValues) > 0;

        } catch (Exception e) {
            return false;
        }
        return result;
    }


    public com.example.artkib.Account login(String username, String password) {
        com.example.artkib.Account account = null;
        try {
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery("Select * from ArtKib where username = ? and password = ?", new String[]{username, password});
            if (cursor.moveToFirst()) {
                account = new Account();
                account.setId(cursor.getInt(0));
                account.setFullname(cursor.getString(1));
                account.setUsername(cursor.getString(2));
                account.setEmail(cursor.getString(3));
                account.setPassword(cursor.getString(4));
            }
        } catch (Exception e) {
            account = null;
        }
        return account;
    }

    public com.example.artkib.Account checkUsername(String username) {
        com.example.artkib.Account account = null;
        try {
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery("Select * from ArtKib where username = ?", new String[]{username});
            if (cursor.moveToNext()) {
                account = new Account();
                account.setId(cursor.getInt(0));
                account.setFullname(cursor.getString(1));
                account.setUsername(cursor.getString(2));
                account.setEmail(cursor.getString(3));
                account.setPassword(cursor.getString(4));

            }
        } catch (Exception e) {
            account = null;
        }
        return account;
    }


    //public Cursor ViewData(){
    //   SQLiteDatabase db = this.getWritableDatabase();
    // Cursor cursor = db.rawQuery("Select * from ArtKib",null);
    //return cursor;
    //}



}
