package com.example.northlandcaps.crisis_response;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class CrisisMenu extends AppCompatActivity {
    Button crisis1,crisis2,crisis3,crisis4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crisis_menu);
        this.setTitle("Admin Menu");
        final ImageView blurr = findViewById(R.id.blur2);
        crisis1 = findViewById(R.id.crisistype1);
        crisis2 = findViewById(R.id.crisistype2);
        crisis3 = findViewById(R.id.crisistype3);
        crisis4 = findViewById(R.id.crisistype4);
        blurr.setVisibility(View.GONE);
        final String app_server_url = "http://10.0.2.2/phptesting/fcm_insert.php";
        Global.active =true;
        final Button locationbutton = findViewById(R.id.locationlog1);
        Button logoutbutton = findViewById(R.id.logout1);
        Button GroupChat = findViewById(R.id.groupchat1);
        Button settings = findViewById(R.id.Settings1);
        final Button crisisCall = findViewById(R.id.crisiscallbutton1);
        crisis1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Global.active){
                    SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.FCM_PREF),Context.MODE_PRIVATE);
                    final String token = sharedPreferences.getString(getString(R.string.FCM_TOKEN),"");
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, app_server_url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params = new HashMap<String, String>();
                            params.put("fcm_token",token);

                            return params;
                        }
                    };
                    MySingleton.getmInstance(CrisisMenu.this).addToRequestque(stringRequest);
                }
            }
        }); logoutbutton.setOnClickListener(new View.OnClickListener() {
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
        }); crisisCall.setOnClickListener(new View.OnClickListener() {
            @android.support.annotation.RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                crisisCall.bringToFront();
                crisisCall.setZ(80);
                if (blurr.getVisibility() == View.VISIBLE) {
                    blurr.setVisibility(View.INVISIBLE);
                    Global.active=true;
                } else{
                    blurr.setVisibility(View.VISIBLE);
                    blurr.setZ(25);
                    Global.active = false;
                }
                System.out.println(Global.active);
                if (!Global.active) {
                    crisis1.setVisibility(View.VISIBLE);
                    System.out.println("visibility - "+crisis1.getVisibility());
                    System.out.println("X position - "+crisis1.getX());
                    System.out.println("Y position - "+crisis1.getY());
                    crisis1.setZ(50);
                    Global.active = false;
                    crisis2.setVisibility(View.VISIBLE);
                    crisis2.setZ(50);
                    Global.active = false;
                    crisis3.setVisibility(View.VISIBLE);
                    crisis3.setZ(50);
                    Global.active = false;
                    crisis4.setVisibility(View.VISIBLE);
                    crisis4.setZ(50);
                    Global.active = false;
                    if (Global.animationon){
                        CrisisButtonMoveIntoAnimation();
                    }
                }else{
                    if (Global.animationon) {
                        CrisisButtonMoveAwayAnimation();
                    }
                    crisis1.setVisibility(View.INVISIBLE);
                    Global.active=true;
                    crisis2.setVisibility(View.INVISIBLE);
                    Global.active=true;
                    crisis3.setVisibility(View.INVISIBLE);
                    Global.active=true;
                    crisis4.setVisibility(View.INVISIBLE);
                    Global.active=true;

                }
            }
        });
        locationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent location = new Intent(getApplicationContext(),location_log_activity.class);
                startActivity(location);
            }
        });}
        @Override
        protected void onResume() {
            super.onResume();
            final ConstraintLayout adminmenu = findViewById(R.id.crisismenu);
            Button locationbutton = findViewById(R.id.locationlog1);
            Button logoutbutton = findViewById(R.id.logout1);
            Button GroupChat = findViewById(R.id.groupchat1);
            Button settings = findViewById(R.id.Settings1);
            Button crisisCall = findViewById(R.id.crisiscallbutton1);
            crisis1 = findViewById(R.id.crisistype1);
            crisis2 = findViewById(R.id.crisistype2);
            crisis3 = findViewById(R.id.crisistype3);
            crisis4 = findViewById(R.id.crisistype4);
            if (Global.themetype==0){
                adminmenu.setBackground(Global.DarkGD);
                logoutbutton.setTextColor(Global.textdarkcolors);
                GroupChat.setTextColor(Global.textdarkcolors);
                settings.setTextColor(Global.textdarkcolors);

                crisisCall.setTextColor(Global.textdarkcolors);
                locationbutton.setTextColor(Global.textdarkcolors);
                crisis4.setTextColor(Global.textdarkcolors);
                /////////////////////////////////////////////////
                logoutbutton.setBackgroundResource(R.drawable.darkredbuttons);
                crisis4.setBackgroundResource(R.drawable.dark_menu_buttons);
                GroupChat.setBackgroundResource(R.drawable.dark_menu_buttons);
                settings.setBackgroundResource(R.drawable.dark_menu_buttons);

                locationbutton.setBackgroundResource(R.drawable.dark_menu_buttons);
                crisisCall.setBackgroundResource(R.drawable.dark_call_button);
            }else if (Global.themetype==1) {
                adminmenu.setBackground(Global.NormalGD);
                logoutbutton.setTextColor(Global.textnormalcolors);
                GroupChat.setTextColor(Global.textnormalcolors);
                settings.setTextColor(Global.textnormalcolors);

                crisisCall.setTextColor(Global.textnormalcolors);
                locationbutton.setTextColor(Global.textnormalcolors);
                crisis4.setTextColor(Global.textnormalcolors);
                /////////////////////////////////////////////////
                logoutbutton.setBackgroundResource(R.drawable.redbuttons);
                GroupChat.setBackgroundResource(R.drawable.menu_buttons);
                settings.setBackgroundResource(R.drawable.menu_buttons);

                locationbutton.setBackgroundResource(R.drawable.menu_buttons);
                crisisCall.setBackgroundResource(R.drawable.call_button);
                crisis4.setBackgroundResource(R.drawable.menu_buttons);
            }else if (Global.themetype==2){
                adminmenu.setBackground(Global.LightGD);
                logoutbutton.setTextColor(Global.textlightcolors);
                GroupChat.setTextColor(Global.textlightcolors);
                settings.setTextColor(Global.textlightcolors);

                crisisCall.setTextColor(Global.textlightcolors);
                locationbutton.setTextColor(Global.textlightcolors);
                crisis4.setTextColor(Global.textlightcolors);
                /////////////////////////////////////////////////
                logoutbutton.setBackgroundResource(R.drawable.lightredbuttons);
                GroupChat.setBackgroundResource(R.drawable.light_menu_button);
                settings.setBackgroundResource(R.drawable.light_menu_button);

                locationbutton.setBackgroundResource(R.drawable.light_menu_button);
                crisisCall.setBackgroundResource(R.drawable.light_call_button);
                crisis4.setBackgroundResource(R.drawable.light_menu_button);
            }
        } public void CrisisButtonMoveIntoAnimation(){
        Animation btn = new TranslateAnimation(Animation.ABSOLUTE,Animation.ABSOLUTE,Animation.ABSOLUTE+10000,Animation.ABSOLUTE);
        btn.setDuration(500);
        btn.setFillAfter(true);

        crisis1.startAnimation(btn);
        crisis2.startAnimation(btn);
        crisis3.startAnimation(btn);
        crisis4.startAnimation(btn);
    }
    public  void CrisisButtonMoveAwayAnimation() {
        Animation btn = new TranslateAnimation(Animation.ABSOLUTE,Animation.ABSOLUTE,Animation.ABSOLUTE,10000);
        btn.setDuration(500);
        btn.setFillAfter(true);

        crisis1.startAnimation(btn);
        crisis2.startAnimation(btn);
        crisis3.startAnimation(btn);
        crisis4.startAnimation(btn);
    }
}

