package com.example.northlandcaps.crisis_response;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class buildingmangement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buildingmangement);
        this.setTitle("Building Management");
        final ConstraintLayout buildingmanagement =findViewById(R.id.buildingmanagerpage);
        if (Global.themetype ==0){
            buildingmanagement.setBackground(Global.DarkGD);
        }else if (Global.themetype ==1){
            buildingmanagement.setBackground(Global.NormalGD);
        }else if (Global.themetype ==2){
            buildingmanagement.setBackground(Global.LightGD);
        }
    }
}
