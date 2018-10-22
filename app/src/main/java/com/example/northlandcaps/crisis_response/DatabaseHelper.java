package com.example.northlandcaps.crisis_response;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME= "register.db";
    public static final String TABLE_NAME="register";
    public static final String COL_1="Username";
    public static final String COL_2="Password";
    public static final String COL_3="IsAdmin";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(("CREATE TABLE") + TABLE_NAME + ("ID INTEGER PRIMARY KEY AUTO INCREMENT, Username TEXT, Password TEXT, IsAdmin TEXT)"));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(("DROP TABLE IF EXIST")+TABLE_NAME);
        onCreate(db);
    }
}
