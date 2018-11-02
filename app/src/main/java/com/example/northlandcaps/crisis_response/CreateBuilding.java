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
<<<<<<< HEAD

    @Override
    protected void onResume() {
        super.onResume();
        final ConstraintLayout createbuildingpage = findViewById(R.id.createbuildingpage);
        Button AddBuilding = findViewById(R.id.AddBuilding);

        if (Global.themetype == 0) {
            createbuildingpage.setBackground(Global.DarkGD);
            AddBuilding.setBackgroundResource(R.drawable.dark_menu_buttons);
            AddBuilding.setTextColor(Global.textdarkcolors);
        } else if (Global.themetype == 1) {
            createbuildingpage.setBackground(Global.NormalGD);
            AddBuilding.setBackgroundResource(R.drawable.menu_buttons);
            AddBuilding.setTextColor(Global.textnormalcolors);
        } else if (Global.themetype == 2) {
            createbuildingpage.setBackground(Global.DarkGD);
            AddBuilding.setBackgroundResource(R.drawable.light_menu_button);
            AddBuilding.setTextColor(Global.textlightcolors);
=======

    @Override
    protected void onResume() {
        super.onResume();
        Button CreateBuilding = findViewById(R.id.CreateBuilding2);
        EditText createbuildingtxt = findViewById(R.id.createbuildingtxt);
        ConstraintLayout createbuildinglayout = findViewById(R.id.CreateBuildingLayout);
        if (Global.themetype ==0){
            createbuildinglayout.setBackground(Global.DarkGD);

            createbuildingtxt.setTextColor(Global.textdarkcolors);
            CreateBuilding.setTextColor(Global.textdarkcolors);
            ////////////////////////////////////////////////
            CreateBuilding.setBackgroundResource(R.drawable.dark_menu_buttons);
        }
        else if (Global.themetype ==1){
            createbuildinglayout.setBackground(Global.NormalGD);

            createbuildingtxt.setTextColor(Global.textnormalcolors);
            CreateBuilding.setTextColor(Global.textnormalcolors);
            ////////////////////////////////////////////////
            CreateBuilding.setBackgroundResource(R.drawable.menu_buttons);

        }
        else if (Global.themetype ==2){
            createbuildinglayout.setBackground(Global.LightGD);

            createbuildingtxt.setTextColor(Global.textlightcolors);
            CreateBuilding.setTextColor(Global.textlightcolors);
            ////////////////////////////////////////////////
            CreateBuilding.setBackgroundResource(R.drawable.light_menu_button);
>>>>>>> 9245a9a8a7a347f32d131ac1c418b9a50513c451
        }
    }
}
