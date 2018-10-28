package com.example.northlandcaps.crisis_response;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class location_log_activity extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        final ConstraintLayout locationloglayout = findViewById(R.id.locationloglayout);
        if(Global.themetype ==0) {
            locationloglayout.setBackground(Global.DarkGD);
        }
        else if(Global.themetype ==1){
            locationloglayout.setBackground(Global.NormalGD);
        }
        else if(Global.themetype ==2){
            locationloglayout.setBackground(Global.LightGD);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_log_activity);
        this.setTitle("Location Log");
        final ConstraintLayout locationloglayout = findViewById(R.id.locationloglayout);
        if(Global.themetype ==0) {
            locationloglayout.setBackground(Global.DarkGD);
        }
        else if(Global.themetype ==1){
            locationloglayout.setBackground(Global.NormalGD);
        }
        else if(Global.themetype ==2){
            locationloglayout.setBackground(Global.LightGD);
        }
    }
}
