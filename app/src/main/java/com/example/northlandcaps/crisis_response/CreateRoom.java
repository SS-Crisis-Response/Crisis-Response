package com.example.northlandcaps.crisis_response;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class CreateRoom  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_room);



    }

    @Override
    protected void onResume() {
        super.onResume();
        Button CreateRoom = findViewById(R.id.CreateRoom);
        final ConstraintLayout createroomlayout = findViewById(R.id.createroom2);
        EditText roomnametxt = findViewById(R.id.roomnametxt);
        if (Global.themetype ==0){
            createroomlayout.setBackground(Global.DarkGD);
            CreateRoom.setTextColor(Global.textdarkcolors);
            roomnametxt.setTextColor(Global.textdarkcolors);
            ////////////////////////////////////////////////
            CreateRoom.setBackgroundResource(R.drawable.dark_menu_buttons);
        }
        else if (Global.themetype ==1){
            createroomlayout.setBackground(Global.NormalGD);
            CreateRoom.setTextColor(Global.textnormalcolors);
            roomnametxt.setTextColor(Global.textnormalcolors);
            ////////////////////////////////////////////////
            CreateRoom.setBackgroundResource(R.drawable.menu_buttons);
        }
        else if (Global.themetype ==2){
            createroomlayout.setBackground(Global.LightGD);
            CreateRoom.setTextColor(Global.textlightcolors);
            roomnametxt.setTextColor(Global.textlightcolors);
            ////////////////////////////////////////////////
            CreateRoom.setBackgroundResource(R.drawable.light_menu_button);
        }
    }
}