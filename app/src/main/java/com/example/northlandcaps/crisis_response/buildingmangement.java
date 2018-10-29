package com.example.northlandcaps.crisis_response;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class buildingmangement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buildingmangement);
        this.setTitle("Building Management");
        final ConstraintLayout buildingmanagement =findViewById(R.id.buildingmanagerpage);
        Button CreateBuilding = findViewById(R.id.CreateRoom);
        Button EditBuilding = findViewById(R.id.EditRoom);
        Button DeleteBuilding = findViewById(R.id.DeleteBuilding);
        if (Global.themetype ==0){
            buildingmanagement.setBackground(Global.DarkGD);
            CreateBuilding.setTextColor(Global.textdarkcolors);
            CreateBuilding.setBackground(Global.DarkGD);
            EditBuilding.setTextColor(Global.textdarkcolors);
            EditBuilding.setBackground(Global.DarkGD);
            DeleteBuilding.setTextColor(Global.textdarkcolors);
            DeleteBuilding.setBackground(Global.DarkGD);
        }else if (Global.themetype ==1){
            buildingmanagement.setBackground(Global.NormalGD);
            CreateBuilding.setTextColor(Global.textnormalcolors);
            CreateBuilding.setBackground(Global.NormalGD);
            EditBuilding.setTextColor(Global.textnormalcolors);
            EditBuilding.setBackground(Global.NormalGD);
            DeleteBuilding.setTextColor(Global.textnormalcolors);
            DeleteBuilding.setBackground(Global.NormalGD);
        }else if (Global.themetype ==2){
            buildingmanagement.setBackground(Global.LightGD);
            CreateBuilding.setTextColor(Global.textlightcolors);
            CreateBuilding.setBackground(Global.LightGD);
            EditBuilding.setTextColor(Global.textlightcolors);
            EditBuilding.setBackground(Global.LightGD);
            DeleteBuilding.setTextColor(Global.textlightcolors);
            DeleteBuilding.setBackground(Global.LightGD);
        }
    }
}
