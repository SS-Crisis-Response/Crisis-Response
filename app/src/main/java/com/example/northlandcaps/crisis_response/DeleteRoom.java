package com.example.northlandcaps.crisis_response;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class DeleteRoom extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_room);
        Spinner Rooms = findViewById(R.id.spinner4);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Global.items);
        Rooms.setAdapter(adapter1);
    }
    @Override
    protected void onResume() {
        super.onResume();
        final ConstraintLayout deleteroomlayout = findViewById(R.id.DeleteRoom2);
        Button DeleteBotton2 = findViewById(R.id.DeleteButton2);
        if (Global.themetype ==0){
            deleteroomlayout.setBackground(Global.DarkGD);
            DeleteBotton2.setBackgroundResource(R.drawable.darkredbuttons);
        }
        else if (Global.themetype ==1){
            deleteroomlayout.setBackground(Global.NormalGD);
            DeleteBotton2.setBackgroundResource(R.drawable.redbuttons);
        }
        else if (Global.themetype ==2){
            deleteroomlayout.setBackground(Global.LightGD);
            DeleteBotton2.setBackgroundResource(R.drawable.lightredbuttons);
        }


    }
}
