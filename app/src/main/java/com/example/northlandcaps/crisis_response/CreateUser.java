package com.example.northlandcaps.crisis_response;


import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;

public class CreateUser extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        this.setTitle("Create User");
        final EditText username1 = findViewById(R.id.Createusername);
        final EditText password1 = findViewById(R.id.Createpassword);
        final Switch isAdmin = findViewById(R.id.isadmin);
        final Button createuser = findViewById(R.id.createuserbtn);
        if (getIntent().hasExtra("com.example.northlandcaps.crisis_response")){
            isAdmin.setVisibility(View.GONE);
        }
        createuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = username1.getText().toString();
                final String password = password1.getText().toString();
                final boolean isadmin1 = isAdmin.isChecked();
                final String isadmin;
                if (isadmin1){
                    isadmin = "true";
                }else {
                    isadmin = "false";
                }
                HashMap<String, String> data = new HashMap<>();
                data.put("username", username);//define the value
                data.put("password", password);//define the value
                data.put("is_admin", isadmin);//define the value
                SendData sendData = new SendData(getApplicationContext(), "http://192.168.10.109:80/phptesting/Register.php", data); //define the context and url properly
                sendData.setOnDataSent(new SendData.OnDataSent() {
                    @Override
                    public void onSuccess(String response) {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailed(String error) {
                        Log.d("Error: ", error);
                    }
                });
                sendData.send();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        final ConstraintLayout createuserpage = findViewById(R.id.createuser);
        EditText createusername = findViewById(R.id.Createusername);
        EditText createpassword = findViewById(R.id.Createpassword);
        Switch isAdmin = findViewById(R.id.isadmin);
        Button createuserbtn = findViewById(R.id.createuserbtn);
            if (Global.themetype==0){
            createuserpage.setBackground(Global.DarkGD);
            createusername.setTextColor(Global.textdarkcolors);
            createpassword.setTextColor(Global.textdarkcolors);
            isAdmin.setTextColor(Global.textdarkcolors);
            createuserbtn.setTextColor(Global.textdarkcolors);
            /////////////////////////////////////////////////
            createuserbtn.setBackgroundResource(R.drawable.dark_menu_buttons);
        }else if (Global.themetype==1) {
            createuserpage.setBackground(Global.NormalGD);
            createusername.setTextColor(Global.textnormalcolors);
            createpassword.setTextColor(Global.textnormalcolors);
            isAdmin.setTextColor(Global.textnormalcolors);
            createuserbtn.setTextColor(Global.textnormalcolors);
            /////////////////////////////////////////////////
            createuserbtn.setBackgroundResource(R.drawable.menu_buttons);
        }else if (Global.themetype==2){
            createuserpage.setBackground(Global.LightGD);
            createusername.setTextColor(Global.textlightcolors);
            createpassword.setTextColor(Global.textlightcolors);
            isAdmin.setTextColor(Global.textlightcolors);
            createuserbtn.setTextColor(Global.textlightcolors);
            /////////////////////////////////////////////////
            createuserbtn.setBackgroundResource(R.drawable.light_menu_button);
        }
    }
}


