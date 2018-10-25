package com.example.northlandcaps.crisis_response;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Sign In");
        final EditText username = findViewById(R.id.password);
        final EditText password = findViewById(R.id.username);
        final Button loginbtn = findViewById(R.id.loginbutton);
        final TextView registerlink = (TextView)findViewById(R.id.registertxtv);

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
                Intent login = new Intent(getApplicationContext(),AdminMenu.class);
                startActivity(login);
            }
        });
    }
}
