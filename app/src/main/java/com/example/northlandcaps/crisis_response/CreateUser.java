package com.example.northlandcaps.crisis_response;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CreateUser extends AppCompatActivity {
    public static FirebaseUser user;
    private FirebaseAuth mAuth;
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
                //when create user button is clicked
                String getusername = username1.getText().toString().trim();
                String getpassword = password1.getText().toString().trim();
                callsignup(getusername,getpassword);
            }
        });

    }
    //how sign up for users works
    private void callsignup(String email,String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("TESTING", "Sign up successful");
                        if (!task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(CreateUser.this,"Sign up failed",Toast.LENGTH_SHORT).show();
                        } else {
                            MainActivity thing = new MainActivity();
                            thing.userProfile();
                            Toast.makeText(CreateUser.this,"Created Account",Toast.LENGTH_SHORT).show();
                            // If sign in fails, display a message to the user.
                            Log.d("TESTING", "Created Account", task.getException());
                        }

                        // ...
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
                //dark theme
                createuserpage.setBackground(Global.DarkGD);
            createusername.setTextColor(Global.textdarkcolors);
            createpassword.setTextColor(Global.textdarkcolors);
            isAdmin.setTextColor(Global.textdarkcolors);
            createuserbtn.setTextColor(Global.textdarkcolors);
            /////////////////////////////////////////////////
            createuserbtn.setBackgroundResource(R.drawable.dark_menu_buttons);
        }else if (Global.themetype==1) {
                //normal theme
            createuserpage.setBackground(Global.NormalGD);
            createusername.setTextColor(Global.textnormalcolors);
            createpassword.setTextColor(Global.textnormalcolors);
            isAdmin.setTextColor(Global.textnormalcolors);
            createuserbtn.setTextColor(Global.textnormalcolors);
            /////////////////////////////////////////////////
            createuserbtn.setBackgroundResource(R.drawable.menu_buttons);
        }else if (Global.themetype==2){
                //light theme
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


