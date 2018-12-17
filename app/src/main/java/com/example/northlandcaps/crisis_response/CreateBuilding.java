package com.example.northlandcaps.crisis_response;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CreateBuilding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_building);

        final EditText BuildingName, RoomName;
        BuildingName = findViewById(R.id.createbuildingtxt);
        RoomName = findViewById(R.id.createroomtxt);
        final Button AddBuilding, DeleteBuilding;
        AddBuilding = findViewById(R.id.AddBuilding);
        DeleteBuilding = findViewById(R.id.DeleteBuilding);

        // Firebase Database Reference
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference fDatabaseRoot = database.getReference("");

        AddBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If both Building and Room are empty
                if (BuildingName.getText().toString().equals("") && RoomName.getText().toString().equals("")) {

                    Toast.makeText(CreateBuilding.this, "You can't create Nothing!", Toast.LENGTH_SHORT).show();
                }
                // If both Building and Room is filled
                else if (!BuildingName.getText().toString().equals("") && !RoomName.getText().toString().equals("")) {

                    fDatabaseRoot.child("buildings").child(BuildingName.getText().toString().trim()).child("buildingName").setValue(BuildingName.getText().toString().trim());
                    fDatabaseRoot.child("rooms").child(RoomName.getText().toString().trim()).child("roomName").setValue(RoomName.getText().toString().trim());

                    BuildingName.setText("");
                    RoomName.setText("");
                    Toast.makeText(CreateBuilding.this, "Created Building and Room", Toast.LENGTH_SHORT).show();
                }
                // If Building is Filled but Room is empty
                else if (!BuildingName.getText().toString().equals("") && RoomName.getText().toString().equals("")) {

                    fDatabaseRoot.child("buildings").child(BuildingName.getText().toString().trim()).child("buildingName").setValue(BuildingName.getText().toString().trim());

                    BuildingName.setText("");
                    Toast.makeText(CreateBuilding.this, "Created Building", Toast.LENGTH_SHORT).show();
                }
                // If Room is filled but Building is empty
                else if (BuildingName.getText().toString().equals("") && !RoomName.getText().toString().equals("")) {

                    fDatabaseRoot.child("rooms").child(RoomName.getText().toString().trim()).child("roomName").setValue(RoomName.getText().toString().trim());

                    RoomName.setText("");
                    Toast.makeText(CreateBuilding.this, "Created Room", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Removing Values from the Database
        DeleteBuilding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If both Building and Room are empty
                if (BuildingName.getText().toString().equals("") && RoomName.getText().toString().equals("")) {

                    Toast.makeText(CreateBuilding.this, "You can't delete nothing!", Toast.LENGTH_SHORT).show();
                }
                // If both Building and Room is filled
                else if (!BuildingName.getText().toString().equals("") && !RoomName.getText().toString().equals("")) {

                    fDatabaseRoot.child("buildings").child(BuildingName.getText().toString().trim()).child("buildingName").removeValue();
                    fDatabaseRoot.child("rooms").child(RoomName.getText().toString().trim()).child("roomName").removeValue();

                    BuildingName.setText("");
                    RoomName.setText("");
                    Toast.makeText(CreateBuilding.this, "Deleted Building and Room", Toast.LENGTH_SHORT).show();
                }
                // If Building is Filled but Room is empty
                else if (!BuildingName.getText().toString().equals("") && RoomName.getText().toString().equals("")) {

                    fDatabaseRoot.child("buildings").child(BuildingName.getText().toString().trim()).child("buildingName").removeValue();

                    BuildingName.setText("");
                    Toast.makeText(CreateBuilding.this, "Building Deleted", Toast.LENGTH_SHORT).show();
                }
                // If Room is filled but Building is empty
                else if (BuildingName.getText().toString().equals("") && !RoomName.getText().toString().equals("")) {

                    fDatabaseRoot.child("rooms").child(RoomName.getText().toString().trim()).child("roomName").removeValue();

                    RoomName.setText("");
                    Toast.makeText(CreateBuilding.this, "Room Deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        final ConstraintLayout createbuildingpage = findViewById(R.id.CreateBuildingLayout);

        if (Global.themetype == 0) {
            //dark theme
            createbuildingpage.setBackground(Global.DarkGD);
            AddBuilding.setBackgroundResource(R.drawable.dark_menu_buttons);
            AddBuilding.setTextColor(Global.textdarkcolors);
            DeleteBuilding.setBackgroundResource(R.drawable.dark_menu_buttons);
            DeleteBuilding.setTextColor(Global.textdarkcolors);
            BuildingName.setTextColor(Global.textdarkcolors);
            RoomName.setTextColor(Global.textdarkcolors);
        } else if (Global.themetype == 1) {
            //normal theme
            createbuildingpage.setBackground(Global.NormalGD);
            AddBuilding.setBackgroundResource(R.drawable.menu_buttons);
            AddBuilding.setTextColor(Global.textnormalcolors);
            DeleteBuilding.setBackgroundResource(R.drawable.menu_buttons);
            DeleteBuilding.setTextColor(Global.textnormalcolors);
            BuildingName.setTextColor(Global.textnormalcolors);
            RoomName.setTextColor(Global.textnormalcolors);
        } else if (Global.themetype == 2) {
            //light theme
            createbuildingpage.setBackground(Global.DarkGD);
            AddBuilding.setBackgroundResource(R.drawable.light_menu_button);
            AddBuilding.setTextColor(Global.textlightcolors);
            DeleteBuilding.setBackgroundResource(R.drawable.light_menu_button);
            DeleteBuilding.setTextColor(Global.textlightcolors);
            BuildingName.setTextColor(Global.textlightcolors);
            RoomName.setTextColor(Global.textlightcolors);
        }
    }
}
