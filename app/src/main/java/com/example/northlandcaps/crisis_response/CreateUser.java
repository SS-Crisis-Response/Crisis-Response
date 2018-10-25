package com.example.northlandcaps.crisis_response;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class CreateUser extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        this.setTitle("Create User");
        final EditText username = findViewById(R.id.Createusername);
        final EditText password = findViewById(R.id.CreatePassword);
        final Switch isAdmin = findViewById(R.id.isadmin);

        final Button createuser = findViewById(R.id.createuserbtn);
        if (getIntent().hasExtra("com.example.northlandcaps.crisis_response")){
            isAdmin.setVisibility(View.GONE);
        }
    }
}


