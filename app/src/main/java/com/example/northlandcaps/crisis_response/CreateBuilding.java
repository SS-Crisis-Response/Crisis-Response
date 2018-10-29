package com.example.northlandcaps.crisis_response;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class CreateBuilding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_building);
        Button CreateBuilding = findViewById(R.id.AddBuilding);

        if (Global.themetype ==0){
            CreateBuilding.setBackground(Global.DarkGD);
            CreateBuilding.setBackgroundResource(R.drawable.dark_menu_buttons);
            CreateBuilding.setTextColor(Global.textdarkcolors);
        }
        else if (Global.themetype ==1){
            CreateBuilding.setBackground(Global.NormalGD);
            CreateBuilding.setBackgroundResource(R.drawable.menu_buttons);
            CreateBuilding.setTextColor(Global.textnormalcolors);
        }
        else if (Global.themetype ==2){
            CreateBuilding.setBackground(Global.LightGD);
            CreateBuilding.setBackgroundResource(R.drawable.light_menu_button);
            CreateBuilding.setTextColor(Global.textlightcolors);
        }
    }
}
