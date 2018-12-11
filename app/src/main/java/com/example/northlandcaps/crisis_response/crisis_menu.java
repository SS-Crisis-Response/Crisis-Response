package com.example.northlandcaps.crisis_response;


import android.app.Notification;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.StrictMode;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import static com.example.northlandcaps.crisis_response.App.CHANNEL_1_ID;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;
import com.onesignal.OneSignal;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class crisis_menu extends AppCompatActivity {
private FirebaseAuth mAuth;
Button crisis1,crisis2,crisis3,crisis4,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crisis_menu);
        final ImageView blurr = findViewById(R.id.blur2);
        crisis1 = findViewById(R.id.crisistype1);
        crisis2 = findViewById(R.id.crisistype2);
        crisis3 = findViewById(R.id.crisistype3);
        crisis4 = findViewById(R.id.crisistype4);
        blurr.setVisibility(View.GONE);
        Global.active =true;
        final Button locationbutton = findViewById(R.id.locationlog);
        logout = findViewById(R.id.logout);
        Button GroupChat = findViewById(R.id.groupchat);
        Button settings = findViewById(R.id.Settings);
        final Button crisisCall = findViewById(R.id.crisiscallbutton);
        //when they click crisis call
        crisis1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Global.active){
                    final String[] SynergyEmails = {"ruinhard@gmail.com", "harveym4662@gmail.com","user1@gmail.com"}; //an array containing all emails of personnel
                    for (int y = 0; y < SynergyEmails.length; y++) { //repeats the sendNotif until every signed in user has gotten an notif
                        if (SynergyEmails[y].equals(MainActivity.LoggedIn_Username)) { //if the phone that will recieve the notif has the same email as yours (aka your own phone), skip
                            continue;
                        }
                        sendNotification(SynergyEmails[y],"Physical");
                    }
                }
            }
        });
        //user logging out
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.active){
                    mAuth.signOut();
                    OneSignal.sendTag("User_ID", "");
                    finish();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }
        });
        //group chat function
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
        //settings menu
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.active) {
                    Intent settings = new Intent(getApplicationContext(), setingshandler.class);
                    startActivity(settings);
                }
            }
        });
        //the base bottom button for crisis call
        crisisCall.setOnClickListener(new View.OnClickListener() {
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
        //location log menu button
        locationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent location = new Intent(getApplicationContext(),location_log_activity.class);
                startActivity(location);
            }
        });
    }
    //////////////////the behemoth of styling////////////////
    @Override
    protected void onResume() {
        super.onResume();
        final ConstraintLayout crisismenu = findViewById(R.id.crisis_menu);
        Button locationbutton = findViewById(R.id.locationlog);
        Button logoutbutton = findViewById(R.id.logout);
        Button GroupChat = findViewById(R.id.groupchat);
        Button settings = findViewById(R.id.Settings);
        Button crisisCall = findViewById(R.id.crisiscallbutton);
        crisis1 = findViewById(R.id.crisistype1);
        crisis2 = findViewById(R.id.crisistype2);
        crisis3 = findViewById(R.id.crisistype3);
        crisis4 = findViewById(R.id.crisistype4);
        if (Global.themetype==0){
            crisismenu.setBackground(Global.DarkGD);
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
            crisismenu.setBackground(Global.NormalGD);
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
            crisismenu.setBackground(Global.LightGD);
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
    }
    /////////////////////////////////////////////////////////
    ////////////////////////Methods//////////////////////////
    public void CrisisButtonMoveIntoAnimation(){
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


        mAuth = FirebaseAuth.getInstance();
        logout =findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                OneSignal.sendTag("User_ID", "");
                finish();
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }
    private void sendNotification(final String SynergyEmail, final String crisis) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                int SDK_INT = android.os.Build.VERSION.SDK_INT;
                if (SDK_INT > 8) {
                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                            .permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    try {
                        String jsonResponse;

                        URL url = new URL("https://onesignal.com/api/v1/notifications");
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setUseCaches(false);
                        con.setDoOutput(true);
                        con.setDoInput(true);

                        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                        con.setRequestProperty("Authorization", "Basic Mzk2YWEzOGUtMWEwNC00ZmZkLWFiMTQtN2JkYjNlNWZkYTk0"); //Rest API Key
                        con.setRequestMethod("POST");
                        String message = crisis + " emergency in ";
                        String strJsonBody = "{"
                                + "\"app_id\": \"43140cf2-d7a7-4430-8404-e0c6e644a11e\"," //One Signal app id

                                + "\"filters\": [{\"field\": \"tag\", \"key\": \"User_ID\", \"relation\": \"=\", \"value\": \"" + SynergyEmail + "\"}],"

                                + "\"data\": {\"foo\": \"bar\"},"
                                + "\"contents\": {\"en\": \""+message+"\"}"
                                + "}";


                        System.out.println("strJsonBody:\n" + strJsonBody);

                        byte[] sendBytes = strJsonBody.getBytes("UTF-8");
                        con.setFixedLengthStreamingMode(sendBytes.length);

                        OutputStream outputStream = con.getOutputStream();
                        outputStream.write(sendBytes);

                        int httpResponse = con.getResponseCode();
                        System.out.println("httpResponse: " + httpResponse);

                        if (httpResponse >= HttpURLConnection.HTTP_OK
                                && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
                            Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
                            jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                            scanner.close();
                        } else {
                            Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
                            jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
                            scanner.close();
                        }
                        System.out.println("jsonResponse:\n" + jsonResponse);

                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
            }
        });
    }
    ///////////////////////////////////////////////////
}



