package com.example.northlandcaps.crisis_response;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class roommanagement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roommanagement);
        this.setTitle("Room Management");
        Button createroombtn = findViewById(R.id.CreateRoombtn);
        createroombtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CreateRoom.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ConstraintLayout roomanager = findViewById(R.id.roommanager);
        Button CreateRoom = findViewById(R.id.CreateRoombtn);
        Button EditRoom = findViewById(R.id.EditRoom);
        Button DeleteRoom = findViewById(R.id.DeleteRoom);
        if (Global.themetype==0){
            roomanager.setBackground(Global.DarkGD);
            CreateRoom.setTextColor(Global.textdarkcolors);
            EditRoom.setTextColor(Global.textdarkcolors);
            DeleteRoom.setTextColor(Global.textdarkcolors);
            /////////////////////////////////////////////
            CreateRoom.setBackgroundResource(R.drawable.dark_menu_buttons);
            EditRoom.setBackgroundResource(R.drawable.dark_menu_buttons);
            DeleteRoom.setBackgroundResource(R.drawable.darkredbuttons);
        }
        else if (Global.themetype==1){
            roomanager.setBackground(Global.NormalGD);
            CreateRoom.setTextColor(Global.textnormalcolors);
            EditRoom.setTextColor(Global.textnormalcolors);
            DeleteRoom.setTextColor(Global.textnormalcolors);
            /////////////////////////////////////////////
            CreateRoom.setBackgroundResource(R.drawable.menu_buttons);
            EditRoom.setBackgroundResource(R.drawable.menu_buttons);
            DeleteRoom.setBackgroundResource(R.drawable.redbuttons);
        }
        else if(Global.themetype==2){
            roomanager.setBackground(Global.LightGD);
            CreateRoom.setTextColor(Global.textlightcolors);
            EditRoom.setTextColor(Global.textlightcolors);
            DeleteRoom.setTextColor(Global.textlightcolors);
            /////////////////////////////////////////////
            CreateRoom.setBackgroundResource(R.drawable.light_menu_button);
            EditRoom.setBackgroundResource(R.drawable.light_menu_button);
            DeleteRoom.setBackgroundResource(R.drawable.lightredbuttons);
        }
    }
}
