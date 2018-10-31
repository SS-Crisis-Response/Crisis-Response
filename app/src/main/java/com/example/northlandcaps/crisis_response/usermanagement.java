package com.example.northlandcaps.crisis_response;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class usermanagement extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        final ConstraintLayout usermanagementlayout = findViewById(R.id.usermangementlayout);
        Button createuser = findViewById(R.id.Createuser);
        Button edituser = findViewById(R.id.edituser);
        Button deleteuser = findViewById(R.id.deleteuser);
        if(Global.themetype ==0) {
            usermanagementlayout.setBackground(Global.DarkGD);
            createuser.setBackgroundResource(R.drawable.dark_menu_buttons);
            edituser.setBackgroundResource(R.drawable.dark_menu_buttons);
            deleteuser.setBackgroundResource(R.drawable.dark_menu_buttons);
            createuser.setTextColor(Global.textdarkcolors);
            edituser.setTextColor(Global.textdarkcolors);
            deleteuser.setTextColor(Global.textdarkcolors);
        }
        else if(Global.themetype ==1){
            usermanagementlayout.setBackground(Global.NormalGD);
            createuser.setBackgroundResource(R.drawable.menu_buttons);
            edituser.setBackgroundResource(R.drawable.menu_buttons);
            deleteuser.setBackgroundResource(R.drawable.menu_buttons);
            createuser.setTextColor(Global.textnormalcolors);
            edituser.setTextColor(Global.textnormalcolors);
            deleteuser.setTextColor(Global.textnormalcolors);
        }
        else if(Global.themetype ==2){
            usermanagementlayout.setBackground(Global.LightGD);
            createuser.setBackgroundResource(R.drawable.light_menu_button);
            edituser.setBackgroundResource(R.drawable.light_menu_button);
            deleteuser.setBackgroundResource(R.drawable.light_menu_button);
            createuser.setTextColor(Global.textlightcolors);
            edituser.setTextColor(Global.textlightcolors);
            deleteuser.setTextColor(Global.textlightcolors);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usermanagement);
        this.setTitle("User Management");
        Button createuser = findViewById(R.id.Createuser);
        createuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createuserintent = new Intent(getApplicationContext(),CreateUser.class);
                startActivity(createuserintent);
            }
        });
        Button eebtn = findViewById(R.id.eebtn);
        eebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "The devs said they'd me, but they never did come back....",
                        Toast.LENGTH_SHORT);

                toast.show();
            }
        });
    }
}
