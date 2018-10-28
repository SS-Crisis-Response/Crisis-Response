package com.example.northlandcaps.crisis_response;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class CreateUser extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        this.setTitle("Create User");
        final EditText username1 = findViewById(R.id.Createusername);
        final EditText password1 = findViewById(R.id.CreatePassword);
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
                final boolean isadmin = isAdmin.getShowText();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success){
                                Intent intent = new Intent(CreateUser.this, MainActivity.class);
                                CreateUser.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(CreateUser.this);
                                builder.setMessage("Register Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(username,password,isadmin,responseListener);
                RequestQueue queue = Volley.newRequestQueue(CreateUser.this);
                queue.add(registerRequest);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        final ConstraintLayout createuserpage = findViewById(R.id.createuser);
        EditText createusername = findViewById(R.id.Createusername);
        EditText createpassword = findViewById(R.id.CreatePassword);
        Switch isAdmin = findViewById(R.id.isadmin);
        Button createuserbtn = findViewById(R.id.createuserbtn);
        if(Global.themetype ==0) {
            createuserpage.setBackground(Global.DarkGD);
        }
        else if(Global.themetype ==1){
            createuserpage.setBackground(Global.NormalGD);
        }
        else if(Global.themetype ==2){
            createuserpage.setBackground(Global.LightGD);
        }
        if (Global.themetype==0){
            createusername.setTextColor(Global.textdarkcolors);
            createpassword.setTextColor(Global.textdarkcolors);
            isAdmin.setTextColor(Global.textdarkcolors);
            createuserbtn.setTextColor(Global.textdarkcolors);
            /////////////////////////////////////////////////
            createuserbtn.setBackgroundResource(R.drawable.dark_menu_buttons);
        }else if (Global.themetype==1) {
            createusername.setTextColor(Global.textnormalcolors);
            createpassword.setTextColor(Global.textnormalcolors);
            isAdmin.setTextColor(Global.textnormalcolors);
            createuserbtn.setTextColor(Global.textnormalcolors);
            /////////////////////////////////////////////////
            createuserbtn.setBackgroundResource(R.drawable.menu_buttons);
        }else if (Global.themetype==2){
            createusername.setTextColor(Global.textlightcolors);
            createpassword.setTextColor(Global.textlightcolors);
            isAdmin.setTextColor(Global.textlightcolors);
            createuserbtn.setTextColor(Global.textlightcolors);
            /////////////////////////////////////////////////
            createuserbtn.setBackgroundResource(R.drawable.light_menu_button);
        }
    }
}


