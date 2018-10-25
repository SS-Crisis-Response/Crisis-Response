package com.example.northlandcaps.crisis_response;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AdminMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
        this.setTitle("Admin Menu");
        final ImageView blurr = findViewById(R.id.blur);
        blurr.setVisibility(View.GONE);
        Button _logoutbutton = findViewById(R.id.logout);

        Global.active =true;
        _logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.active){
                Intent loginintent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(loginintent);
                }
            }
        });
        Button GroupChat = findViewById(R.id.groupchat);
        GroupChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.active) {
                    String discord = "https://discord.gg/yqjUX6b";
                    Uri webaddress = Uri.parse(discord);
                    Intent chatintent = new Intent(Intent.ACTION_VIEW, webaddress);
                    if (chatintent.resolveActivity(getPackageManager()) != null) {
                        startActivity(chatintent);
                    }
                }
            }
        });
        Button usermanager = findViewById(R.id.usermanager);
        usermanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.active) {
                    Intent usermanager = new Intent(getApplicationContext(), usermanagement.class);
                    startActivity(usermanager);
                }
            }
        });
        Button buildingmanager = findViewById(R.id.buildingmanager);
        buildingmanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.active) {
                    Intent buildingmanager = new Intent(getApplicationContext(), buildingmangement.class);
                    startActivity(buildingmanager);
                }
            }
        });

        Button roommanager = findViewById(R.id.roommanager);
        roommanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.active) {
                    Intent roommanager = new Intent(getApplicationContext(), roommanagement.class);
                    startActivity(roommanager);
                }
            }
        });

        Button crisisCall = findViewById(R.id.crisiscallbutton);
        crisisCall.setOnClickListener(new View.OnClickListener() {
            @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                if (blurr.getVisibility() == View.VISIBLE) {
                    blurr.setVisibility(View.INVISIBLE);
                    Global.active=true;
                }
                    else
                {
                        blurr.setVisibility(View.VISIBLE);
                        blurr.bringToFront();
                        Global.active = false;

                }
            }
        });
        Button settings = findViewById(R.id.Settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settings = new Intent(getApplicationContext(),setingshandler.class);
                startActivity(settings);
            }
        });
        Button locationbutton = findViewById(R.id.locationlog);
        locationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent location = new Intent(getApplicationContext(),location_log_activity.class);
                startActivity(location);
            }
        });
    }
}
