package com.example.northlandcaps.crisis_response;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class location_log_activity extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        final ConstraintLayout locationloglayout = findViewById(R.id.locationloglayout);
        Spinner Buildings = findViewById(R.id.spinner);
        String[] items = new String[]{"to", "be", "Edited", "to", "use", "List", "from", "DataBase"};
        Spinner Rooms = findViewById(R.id.spinner2);
        String[] items1 = new String[]{"one", "two", "3"};
        this.setTitle("Location Log");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        Buildings.setAdapter(adapter);
        Rooms.setAdapter(adapter1);
        TextView BuildingText;
        BuildingText = findViewById(R.id.BuildingText);
        TextView RoomText = findViewById(R.id.RoomText);
        if (Global.themetype == 0) {
            locationloglayout.setBackground(Global.DarkGD);
            BuildingText.setTextColor(Global.textdarkcolors);
            RoomText.setTextColor(Global.textdarkcolors);
        } else if (Global.themetype == 1) {
            locationloglayout.setBackground(Global.NormalGD);
            BuildingText.setTextColor(Global.textdarkcolors);
            RoomText.setTextColor(Global.textdarkcolors);
        } else if (Global.themetype == 2) {
            locationloglayout.setBackground(Global.LightGD);
            BuildingText.setTextColor(Global.textlightcolors);
            RoomText.setTextColor(Global.textlightcolors);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_log_activity);
        Spinner Buildings = findViewById(R.id.spinner);
        String[] items = new String[]{"to", "be", "Edited", "to", "use", "List", "from", "DataBase"};
        Spinner Rooms = findViewById(R.id.spinner2);
        String[] items1 = new String[]{"one", "two", "3"};
        this.setTitle("Location Log");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        Buildings.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);
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