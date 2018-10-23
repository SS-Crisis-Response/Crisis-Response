package com.example.northlandcaps.crisis_response;

import android.content.Intent;
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
                Intent chatintent = new Intent(getApplicationContext(),chat_group.class);
                startActivity(chatintent);
            }
        });

    }
}
