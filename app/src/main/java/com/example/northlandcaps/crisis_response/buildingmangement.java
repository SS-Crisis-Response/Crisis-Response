package com.example.northlandcaps.crisis_response;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class buildingmangement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buildingmangement);
        this.setTitle("Building Management");
        Button addbuilding = findViewById(R.id.CreateBuilding);

        addbuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.active) {
                    Intent addbuilding = new Intent(getApplicationContext(), CreateBuilding.class);
                    startActivity(addbuilding);
                }
                Intent createBuilding = new Intent(getApplicationContext(), CreateBuilding.class);
                startActivity(createBuilding);
            }
        });
        Button editbuilding = findViewById(R.id.EditBuilding);
        editbuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editbuilding = new Intent(getApplicationContext(),EditBuilding.class);
                startActivity(editbuilding);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        final ConstraintLayout buildingmanagement = findViewById(R.id.buildingmanagerpage);
        Button CreateBuilding = findViewById(R.id.CreateBuilding);
        Button EditBuilding = findViewById(R.id.EditBuilding);
        Button DeleteBuilding = findViewById(R.id.DeleteBuilding);
        if (Global.themetype == 0) {
            buildingmanagement.setBackground(Global.DarkGD);
            CreateBuilding.setTextColor(Global.textdarkcolors);
            CreateBuilding.setBackgroundResource(R.drawable.dark_menu_buttons);
            EditBuilding.setTextColor(Global.textdarkcolors);
            EditBuilding.setBackgroundResource(R.drawable.dark_menu_buttons);
            DeleteBuilding.setTextColor(Global.textdarkcolors);
            DeleteBuilding.setBackgroundResource(R.drawable.darkredbuttons);
        } else if (Global.themetype == 1) {
            buildingmanagement.setBackground(Global.NormalGD);
            CreateBuilding.setTextColor(Global.textnormalcolors);
            CreateBuilding.setBackgroundResource(R.drawable.menu_buttons);
            EditBuilding.setTextColor(Global.textnormalcolors);
            EditBuilding.setBackgroundResource(R.drawable.menu_buttons);
            DeleteBuilding.setTextColor(Global.textnormalcolors);
            DeleteBuilding.setBackgroundResource(R.drawable.redbuttons);
        } else if (Global.themetype == 2) {
            buildingmanagement.setBackground(Global.LightGD);
            CreateBuilding.setTextColor(Global.textlightcolors);
            CreateBuilding.setBackgroundResource(R.drawable.light_menu_button);
            EditBuilding.setTextColor(Global.textlightcolors);
            EditBuilding.setBackgroundResource(R.drawable.light_menu_button);
            DeleteBuilding.setTextColor(Global.textlightcolors);
            DeleteBuilding.setBackgroundResource(R.drawable.lightredbuttons);
        }
    }
}
