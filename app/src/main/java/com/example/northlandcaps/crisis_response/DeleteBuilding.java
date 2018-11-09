package com.example.northlandcaps.crisis_response;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;

public class DeleteBuilding  extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_building);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final ConstraintLayout deletebuildinglayout = findViewById(R.id.DeleteBuilding2);
        Button DeleteBotton = findViewById(R.id.DeleteButton);
        if (Global.themetype ==0){
            deletebuildinglayout.setBackground(Global.DarkGD);
            DeleteBotton.setBackgroundResource(R.drawable.darkredbuttons);
        }
        else if (Global.themetype ==1){
            deletebuildinglayout.setBackground(Global.NormalGD);
            DeleteBotton.setBackgroundResource(R.drawable.redbuttons);
        }
        else if (Global.themetype ==2){
            deletebuildinglayout.setBackground(Global.LightGD);
            DeleteBotton.setBackgroundResource(R.drawable.lightredbuttons);
        }


    }

}
