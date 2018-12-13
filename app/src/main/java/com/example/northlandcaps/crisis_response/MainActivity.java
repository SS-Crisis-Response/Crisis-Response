package com.example.northlandcaps.crisis_response;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.FirebaseDatabase;
import com.onesignal.OneSignal;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email,password,name;
    private Button signin,signup;
    FirebaseUser user;
    static String LoggedIn_Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();
        //User IS logged in
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
        if (mAuth.getCurrentUser() != null) {
            //User NOT logged in
            user = mAuth.getCurrentUser();
            LoggedIn_Username = user.getEmail();
            OneSignal.sendTag("User_ID", LoggedIn_Username);
            finish();
            startActivity(new Intent(getApplicationContext(), crisis_menu.class));

        }
        final EditText username = findViewById(R.id.usernametxt);
        final EditText password = findViewById(R.id.passwordtxt);
        final Button loginbtn = findViewById(R.id.loginbutton);
        loginbtn.setTextColor(Color.rgb(0, 0, 0));
        final TextView registerlink = findViewById(R.id.registertxtv);
        registerlink.setTextColor(Color.rgb(0, 0, 0));

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getemail = username.getText().toString().trim();
                String getpassword = password.getText().toString().trim();
                callsignin(getemail, getpassword);
            }

        });
    }
    public void userProfile()
    {
        FirebaseUser user = mAuth.getCurrentUser();
        if(user!= null)
        {
            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    //.setPhotoUri(Uri.parse("https://example.com/jane-q-user/profile.jpg"))  // here you can set image link also.
                    .build();

            user.updateProfile(profileUpdates)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.d("TESTING", "User profile updated.");
                            }
                        }
                    });
        }
    }
    private void callsignin(String email,String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("TESTING", "sign In Successful:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w("TESTING", "signInWithEmail:failed", task.getException());
                            Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            user = mAuth.getCurrentUser();
                            LoggedIn_Username = user.getEmail();
                            OneSignal.sendTag("User_ID", LoggedIn_Username);
                            Intent i = new Intent(MainActivity.this, crisis_menu.class);
                            finish();
                            startActivity(i);
                        }
                    }
                });

    }
}
