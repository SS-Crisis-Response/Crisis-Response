package com.example.northlandcaps.crisis_response;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
        Button _logoutbutton = findViewById(R.id.logout);
        _logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginintent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(loginintent);
            }
        });
        Button GroupChat = findViewById(R.id.groupchat);
        GroupChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String discord = "https://discord.gg/wY3Bbu";
                Uri webaddress = Uri.parse(discord);
                Intent chatintent = new Intent(Intent.ACTION_VIEW,webaddress);
                if (chatintent.resolveActivity(getPackageManager())!= null){
                startActivity(chatintent);
                }
            }
        });
        Button usermanager = findViewById(R.id.usermanager);
        usermanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent usermanager = new Intent(getApplicationContext(),usermanagement.class);
                startActivity(usermanager);
            }
        });
        final Button buildingmanager = findViewById(R.id.buildingmanager);
        buildingmanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buildingmanager = new Intent(getApplicationContext(),buildingmangement.class);
                startActivity(buildingmanager);
            }
        });
    }
}
