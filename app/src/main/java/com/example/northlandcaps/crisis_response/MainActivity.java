package com.example.northlandcaps.crisis_response;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Sign In");
        final EditText username = findViewById(R.id.usernametxt);
        final EditText password = findViewById(R.id.passwordtxt);
        final Button loginbtn = findViewById(R.id.loginbutton);
        loginbtn.setTextColor(Color.rgb(0,0,0));
        final TextView registerlink = findViewById(R.id.registertxtv);
        registerlink.setTextColor(Color.rgb(0,0,0));
        registerlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(getApplicationContext(), CreateUser.class);
                registerIntent.putExtra("com.example.northlandcaps.crisis_response", "Hide");
                startActivity(registerIntent);
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String usertxt = "no";
                final String passtxt = "no";


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response);
                    }
                };
                LoginRequest loginRequest = new LoginRequest(usertxt,passtxt,responseListener,errorListener);
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(loginRequest);
                Intent intent = new Intent(getApplicationContext(), AdminMenu.class);
                startActivity(intent);
            }
        });

    }Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getApplicationContext(), String.valueOf(error), Toast.LENGTH_SHORT).show();
        }
    };
}
