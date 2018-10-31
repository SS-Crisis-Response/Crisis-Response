package com.example.northlandcaps.crisis_response;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class CreateRoom  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_building);
        Button CreateBuilding = findViewById(R.id.CreateBuilding2);

        if (Global.themetype ==0){
            CreateBuilding.setBackgroundResource(R.drawable.dark_menu_buttons);
            CreateBuilding.setTextColor(Global.textdarkcolors);
        }
        else if (Global.themetype ==1){

        }
        else if (Global.themetype ==2){

        }
    }
}