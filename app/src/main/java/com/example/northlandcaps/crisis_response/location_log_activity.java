package com.example.northlandcaps.crisis_response;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class location_log_activity extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        final Spinner Buildings = findViewById(R.id.spinner);
        final Spinner Rooms = findViewById(R.id.spinner2);
        this.setTitle("Location Log");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Global.item);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Global.items);
        Buildings.setAdapter(adapter);
        Rooms.setAdapter(adapter1);
        if (!Global.CurrentBuilding.equals("Nothing")){
            switch (Global.CurrentBuilding){
                case "YRC": Buildings.setSelection(1);
                    System.out.println(Global.CurrentBuilding);
                break;
                case "Parking Lot": Buildings.setSelection(2);
                    System.out.println(Global.CurrentBuilding);
                break;
                case "Synergy House": Buildings.setSelection(3);
                    System.out.println(Global.CurrentBuilding);
                break;
                case "DataBase": Buildings.setSelection(4);
                    System.out.println(Global.CurrentBuilding);
                case "Building": Buildings.setSelection(5);
                    System.out.println(Global.CurrentBuilding);
                default:
                    System.out.println(Global.CurrentBuilding);
                    System.out.println("No Building Found");
                    break;
            }
        }
        Button btnSubmit = findViewById(R.id.locationsubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String building =  Buildings.getSelectedItem().toString();
               String room = Rooms.getSelectedItem().toString();
               Global.CurrentBuilding = building;
               Global.CurrentRoom=room;
                Intent intent = new Intent(getApplicationContext(),crisis_menu.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_log_activity);
        Spinner Buildings = findViewById(R.id.spinner);

        Spinner Rooms = findViewById(R.id.spinner2);

        this.setTitle("Location Log");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Global.item);
        Buildings.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Global.items);
        Rooms.setAdapter(adapter1);
        final ConstraintLayout locationloglayout = findViewById(R.id.locationloglayout);
        TextView BuildingText = findViewById(R.id.BuildingText);
        TextView RoomText = findViewById(R.id.RoomText);
        if (Global.themetype == 0) {
            locationloglayout.setBackground(Global.DarkGD);
            BuildingText.setTextColor(Global.textdarkcolors);
            RoomText.setTextColor(Global.textdarkcolors);
        } else if (Global.themetype == 1) {
            locationloglayout.setBackground(Global.NormalGD);
            BuildingText.setTextColor(Global.textnormalcolors);
            RoomText.setTextColor(Global.textnormalcolors);
        } else if (Global.themetype == 2) {
            locationloglayout.setBackground(Global.LightGD);
            BuildingText.setTextColor(Global.textlightcolors);
            RoomText.setTextColor(Global.textlightcolors);
        }

    }
}