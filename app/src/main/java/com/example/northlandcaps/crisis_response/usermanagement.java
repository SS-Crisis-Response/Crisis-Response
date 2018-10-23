package com.example.northlandcaps.crisis_response;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class usermanagement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermanagement);
        Button createuser = findViewById(R.id.createuserbtn);
        createuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GotoCreate =new Intent(getApplicationContext(),CreateUser.class);
                startActivity(GotoCreate);
            }
        });
    }
}
