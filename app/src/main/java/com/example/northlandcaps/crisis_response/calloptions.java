package com.example.northlandcaps.crisis_response;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class calloptions extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calloptions);
        this.setTitle("Call Options");
        final EditText crisistype1 = findViewById(R.id.CrisisType1);
        final EditText crisistype2 = findViewById(R.id.CrisisType2);
        final EditText crisistype3 = findViewById(R.id.CrisisType3);
        final EditText crisistype4 = findViewById(R.id.CrisisType4);
        final Button createchangesbtn = findViewById(R.id.createchangesbtn);
        createchangesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to edit crisis call buttons
                Intent createchanges = new Intent (getApplicationContext(),AdminMenu.class);
                startActivity(createchanges);
            }
        });
    }
}