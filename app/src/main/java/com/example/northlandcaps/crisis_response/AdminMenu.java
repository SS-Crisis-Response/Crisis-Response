package com.example.northlandcaps.crisis_response;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
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
        Global.active =true;
        Button locationbutton = findViewById(R.id.locationlog);
        Button logoutbutton = findViewById(R.id.logout);
        Button GroupChat = findViewById(R.id.groupchat);
        Button settings = findViewById(R.id.Settings);
        Button calloptions = findViewById(R.id.calloptions);
        Button usermanager = findViewById(R.id.usermanager);
        Button buildingmanager = findViewById(R.id.buildingmanager);
        Button roommanager = findViewById(R.id.roommanager);
        Button crisisCall = findViewById(R.id.crisiscallbutton);


        logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.active){
                Intent loginintent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(loginintent);
                }
            }
        });
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
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.active) {
                    Intent settings = new Intent(getApplicationContext(), setingshandler.class);
                    startActivity(settings);
                }
            }
        });
        calloptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.active) {

                }
            }
        });
        usermanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.active) {
                    Intent usermanager = new Intent(getApplicationContext(), usermanagement.class);
                    startActivity(usermanager);
                }
            }
        });
        buildingmanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.active) {
                    Intent buildingmanager = new Intent(getApplicationContext(), buildingmangement.class);
                    startActivity(buildingmanager);
                }
            }
        });
        roommanager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.active) {
                    Intent roommanager = new Intent(getApplicationContext(), roommanagement.class);
                    startActivity(roommanager);
                }
            }
        });
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
        locationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent location = new Intent(getApplicationContext(),location_log_activity.class);
                startActivity(location);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        final ConstraintLayout adminmenu = findViewById(R.id.adminmenu);
        Button locationbutton = findViewById(R.id.locationlog);
        Button logoutbutton = findViewById(R.id.logout);
        Button GroupChat = findViewById(R.id.groupchat);
        Button settings = findViewById(R.id.Settings);
        Button calloptions = findViewById(R.id.calloptions);
        Button usermanager = findViewById(R.id.usermanager);
        Button buildingmanager = findViewById(R.id.buildingmanager);
        Button roommanager = findViewById(R.id.roommanager);
        Button crisisCall = findViewById(R.id.crisiscallbutton);
        if(Global.themetype ==0) {
            adminmenu.setBackground(Global.DarkGD);
        }
        else if(Global.themetype ==1){
            adminmenu.setBackground(Global.NormalGD);
        }
        else if(Global.themetype ==2){
            adminmenu.setBackground(Global.LightGD);
        }
        if (Global.themetype==0){
            logoutbutton.setTextColor(Global.textdarkcolors);
            GroupChat.setTextColor(Global.textdarkcolors);
            settings.setTextColor(Global.textdarkcolors);
            calloptions.setTextColor(Global.textdarkcolors);
            usermanager.setTextColor(Global.textdarkcolors);
            buildingmanager.setTextColor(Global.textdarkcolors);
            roommanager.setTextColor(Global.textdarkcolors);
            crisisCall.setTextColor(Global.textdarkcolors);
            locationbutton.setTextColor(Global.textdarkcolors);
            /////////////////////////////////////////////////
            logoutbutton.setBackgroundResource(R.drawable.dark_menu_buttons);
            GroupChat.setBackgroundResource(R.drawable.dark_menu_buttons);
            settings.setBackgroundResource(R.drawable.dark_menu_buttons);
            calloptions.setBackgroundResource(R.drawable.dark_menu_buttons);
            usermanager.setBackgroundResource(R.drawable.dark_menu_buttons);
            buildingmanager.setBackgroundResource(R.drawable.dark_menu_buttons);
            roommanager.setBackgroundResource(R.drawable.dark_menu_buttons);
            locationbutton.setBackgroundResource(R.drawable.dark_menu_buttons);
            crisisCall.setBackgroundResource(R.drawable.dark_call_button);
        }else if (Global.themetype==1) {
            logoutbutton.setTextColor(Global.textnormalcolors);
            GroupChat.setTextColor(Global.textnormalcolors);
            settings.setTextColor(Global.textnormalcolors);
            calloptions.setTextColor(Global.textnormalcolors);
            usermanager.setTextColor(Global.textnormalcolors);
            buildingmanager.setTextColor(Global.textnormalcolors);
            roommanager.setTextColor(Global.textnormalcolors);
            crisisCall.setTextColor(Global.textnormalcolors);
            locationbutton.setTextColor(Global.textnormalcolors);
            /////////////////////////////////////////////////
            logoutbutton.setBackgroundResource(R.drawable.menu_buttons);
            GroupChat.setBackgroundResource(R.drawable.menu_buttons);
            settings.setBackgroundResource(R.drawable.menu_buttons);
            calloptions.setBackgroundResource(R.drawable.menu_buttons);
            usermanager.setBackgroundResource(R.drawable.menu_buttons);
            buildingmanager.setBackgroundResource(R.drawable.menu_buttons);
            roommanager.setBackgroundResource(R.drawable.menu_buttons);
            locationbutton.setBackgroundResource(R.drawable.menu_buttons);
            crisisCall.setBackgroundResource(R.drawable.call_button);
        }else if (Global.themetype==2){
            logoutbutton.setTextColor(Global.textlightcolors);
            GroupChat.setTextColor(Global.textlightcolors);
            settings.setTextColor(Global.textlightcolors);
            calloptions.setTextColor(Global.textlightcolors);
            usermanager.setTextColor(Global.textlightcolors);
            buildingmanager.setTextColor(Global.textlightcolors);
            roommanager.setTextColor(Global.textlightcolors);
            crisisCall.setTextColor(Global.textlightcolors);
            locationbutton.setTextColor(Global.textlightcolors);
            /////////////////////////////////////////////////
            logoutbutton.setBackgroundResource(R.drawable.light_menu_button);
            GroupChat.setBackgroundResource(R.drawable.light_menu_button);
            settings.setBackgroundResource(R.drawable.light_menu_button);
            calloptions.setBackgroundResource(R.drawable.light_menu_button);
            usermanager.setBackgroundResource(R.drawable.light_menu_button);
            buildingmanager.setBackgroundResource(R.drawable.light_menu_button);
            roommanager.setBackgroundResource(R.drawable.light_menu_button);
            locationbutton.setBackgroundResource(R.drawable.light_menu_button);
            crisisCall.setBackgroundResource(R.drawable.light_call_button);
        }
    }
}
