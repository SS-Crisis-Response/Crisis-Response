package com.example.northlandcaps.crisis_response;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CreateBuilding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_building);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final ConstraintLayout createbuildingpage = findViewById(R.id.CreateBuildingLayout);
        Button AddBuilding = findViewById(R.id.AddBuilding);

        if (Global.themetype == 0) {
            //dark theme
            createbuildingpage.setBackground(Global.DarkGD);
            AddBuilding.setBackgroundResource(R.drawable.dark_menu_buttons);
            AddBuilding.setTextColor(Global.textdarkcolors);
        } else if (Global.themetype == 1) {
            //normal theme
            createbuildingpage.setBackground(Global.NormalGD);
            AddBuilding.setBackgroundResource(R.drawable.menu_buttons);
            AddBuilding.setTextColor(Global.textnormalcolors);
        } else if (Global.themetype == 2) {
            //light theme
            createbuildingpage.setBackground(Global.DarkGD);
            AddBuilding.setBackgroundResource(R.drawable.light_menu_button);
            AddBuilding.setTextColor(Global.textlightcolors);
        }
    }
}
