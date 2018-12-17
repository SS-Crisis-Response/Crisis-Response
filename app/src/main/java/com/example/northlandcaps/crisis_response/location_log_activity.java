package com.example.northlandcaps.crisis_response;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class location_log_activity extends AppCompatActivity {
    EditText CustomBuilding, CustomRoom;
    @Override
    protected void onResume() {
        super.onResume();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference fDatabaseRoot = database.getReference("");

        // Looking for the Buildings and displaying it in the spinner
        fDatabaseRoot.child("buildings").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final List<String> buildings = new ArrayList<>();

                for (DataSnapshot buildingsSnapshot: dataSnapshot.getChildren()) {
                    String buildingName = buildingsSnapshot.child("buildingName").getValue(String.class);
                    buildings.add(buildingName);
                }

                Spinner buildingSpinner = findViewById(R.id.spinner);
                ArrayAdapter<String> buildingAdapter = new ArrayAdapter<>(location_log_activity.this, android.R.layout.simple_spinner_item, buildings);
                buildingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                buildingSpinner.setAdapter(buildingAdapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        // Looking for the Rooms and displaying it in the spinner
        fDatabaseRoot.child("rooms").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final List<String> rooms = new ArrayList<>();

                for (DataSnapshot roomsSnapshot: dataSnapshot.getChildren()) {
                    String roomName = roomsSnapshot.child("roomName").getValue(String.class);
                    rooms.add(roomName);
                }

                Spinner roomSpinner = findViewById(R.id.spinner2);
                ArrayAdapter<String> roomAdapter = new ArrayAdapter<>(location_log_activity.this, android.R.layout.simple_spinner_item, rooms);
                roomAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                roomSpinner.setAdapter(roomAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        final Spinner Buildings = findViewById(R.id.spinner);
        final Spinner Rooms = findViewById(R.id.spinner2);
        this.setTitle("Location Log");
        //sets up location log (list of buildings and rooms)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Global.item);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Global.items);
        Buildings.setAdapter(adapter);
        Rooms.setAdapter(adapter1);

        if (!Global.CurrentBuilding.equals("Nothing")){
            switch (Global.CurrentBuilding){
                case "YRC": Buildings.setSelection(0);
                    System.out.println(Global.CurrentBuilding);
                break;
                case "Parking Lot": Buildings.setSelection(1);
                    System.out.println(Global.CurrentBuilding);
                break;
                case "Synergy House": Buildings.setSelection(2);
                    System.out.println(Global.CurrentBuilding);
                break;
                default:
                    System.out.println(Global.CurrentBuilding);
                    System.out.println("No Building Found");
                    break;
            }
        }
        if (!Global.CurrentRoom.equals("Nothing")){
            switch (Global.CurrentRoom){
                case "Bathrooms": Rooms.setSelection(0);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Board Room": Rooms.setSelection(1);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "CAC": Rooms.setSelection(2);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Childcare Room": Rooms.setSelection(3);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Clinic": Rooms.setSelection(4);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Conference Room": Rooms.setSelection(5);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Downstairs office": Rooms.setSelection(6);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Drop-in": Rooms.setSelection(7);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Fitness Room": Rooms.setSelection(8);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Front Bathrooms": Rooms.setSelection(9);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Great Room": Rooms.setSelection(10);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Gym": Rooms.setSelection(11);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Kitchen/Dining Room": Rooms.setSelection(12);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Laundry Room": Rooms.setSelection(13);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Library": Rooms.setSelection(14);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Med Room": Rooms.setSelection(15);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Reception": Rooms.setSelection(16);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Recording Studio": Rooms.setSelection(17);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Staff Cube": Rooms.setSelection(18);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Staff Kitchen": Rooms.setSelection(19);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Teaching Kitchen": Rooms.setSelection(20);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Upstairs bedrooms": Rooms.setSelection(21);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Upstairs Group Room": Rooms.setSelection(22);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Upstairs office": Rooms.setSelection(23);
                    System.out.println(Global.CurrentRoom);
                    break;
                case "Youth Alley":Rooms.setSelection(24);
                    System.out.println(Global.CurrentRoom);
                    break;
                default:
                    System.out.println(Global.CurrentRoom);
                    System.out.println("No Building Found");
                    break;
            }
        }
        Button btnSubmit = findViewById(R.id.locationsubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Global.CurrentBuilding = Buildings.getSelectedItem().toString();
               Global.CurrentRoom=Rooms.getSelectedItem().toString();
                Intent intent = new Intent(getApplicationContext(),crisis_menu.class);
                startActivity(intent);
            }
        });
        Button custombtnsubmit = findViewById(R.id.customlocationsubmit);
        CustomBuilding = findViewById(R.id.CustomBuilding);
        CustomRoom = findViewById(R.id.CustomRoom);
        custombtnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!CustomBuilding.getText().toString().equals("") && !CustomRoom.getText().toString().equals("")){
                    Global.CurrentBuilding=CustomBuilding.getText().toString();
                    Global.CurrentRoom=CustomRoom.getText().toString();
                    Intent intent = new Intent(getApplicationContext(),crisis_menu.class);
                    startActivity(intent);
                }else if (!CustomBuilding.getText().toString().equals("") && CustomRoom.getText().toString().equals("")){
                    Global.CurrentBuilding=CustomBuilding.getText().toString();
                    Global.CurrentRoom= Rooms.getSelectedItem().toString();
                    Intent intent = new Intent(getApplicationContext(),crisis_menu.class);
                    startActivity(intent);
                }else  if (!CustomRoom.getText().toString().equals("")&&CustomBuilding.getText().toString().equals("")){
                    Global.CurrentRoom=CustomRoom.getText().toString();
                    Global.CurrentBuilding= Buildings.getSelectedItem().toString();
                    Intent intent = new Intent(getApplicationContext(),crisis_menu.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_log_activity);
        /*Spinner Buildings = findViewById(R.id.spinner);

        Spinner Rooms = findViewById(R.id.spinner2);

        this.setTitle("Location Log");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Global.item);
        Buildings.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Global.items);
        Rooms.setAdapter(adapter1);*/
        final ConstraintLayout locationloglayout = findViewById(R.id.locationloglayout);
        if (Global.themetype == 0) {
            locationloglayout.setBackground(Global.DarkGD);
        } else if (Global.themetype == 1) {
            locationloglayout.setBackground(Global.NormalGD);
        } else if (Global.themetype == 2) {
            locationloglayout.setBackground(Global.LightGD);
        }
    }
}