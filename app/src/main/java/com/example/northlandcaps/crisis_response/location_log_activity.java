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
import android.widget.TextView;

public class location_log_activity extends AppCompatActivity {
    EditText CustomBuilding, CustomRoom;
    @Override
    protected void onResume() {
        super.onResume();




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
        Button customsubmitbtn = findViewById(R.id.customlocationsubmit);
        Button normalsubmitbtn = findViewById(R.id.locationsubmit);
        EditText custombuildingedittxt = findViewById(R.id.CustomBuilding);
        EditText customroomedittxt = findViewById(R.id.CustomRoom);
        TextView buildingtxt = findViewById(R.id.buildingtxt);
        TextView roomtxt = findViewById(R.id.roomtxt);
        Spinner BuildingsSpinner = findViewById(R.id.spinner);
        Spinner RoomsSpinner = findViewById(R.id.spinner2);
        final ConstraintLayout locationlog = findViewById(R.id.locationloglayout);
        if (Global.themetype==0){
            locationlog.setBackground(Global.DarkGD);
            /////////////////////////////////////////
            customsubmitbtn.setTextColor(Global.textdarkcolors);
            normalsubmitbtn.setTextColor(Global.textdarkcolors);
            custombuildingedittxt.setTextColor(Global.textdarkcolors);
            customroomedittxt.setTextColor(Global.textdarkcolors);
            buildingtxt.setTextColor(Global.textdarkcolors);
            roomtxt.setTextColor(Global.textdarkcolors);
            //////////////////////////////////////////
            custombtnsubmit.setBackgroundResource(R.drawable.dark_menu_buttons);
            normalsubmitbtn.setBackgroundResource(R.drawable.dark_menu_buttons);
        }else if(Global.themetype==1){
            locationlog.setBackground(Global.NormalGD);
            /////////////////////////////////////////
            customsubmitbtn.setTextColor(Global.textnormalcolors);
            normalsubmitbtn.setTextColor(Global.textnormalcolors);
            custombuildingedittxt.setTextColor(Global.textnormalcolors);
            customroomedittxt.setTextColor(Global.textnormalcolors);
            buildingtxt.setTextColor(Global.textnormalcolors);
            roomtxt.setTextColor(Global.textnormalcolors);
            //////////////////////////////////////////
            custombtnsubmit.setBackgroundResource(R.drawable.menu_buttons);
            normalsubmitbtn.setBackgroundResource(R.drawable.menu_buttons);
        }else if(Global.themetype==2) {
            locationlog.setBackground(Global.LightGD);
            /////////////////////////////////////////
            customsubmitbtn.setTextColor(Global.textlightcolors);
            normalsubmitbtn.setTextColor(Global.textlightcolors);
            custombuildingedittxt.setTextColor(Global.textlightcolors);
            customroomedittxt.setTextColor(Global.textlightcolors);
            buildingtxt.setTextColor(Global.textlightcolors);
            roomtxt.setTextColor(Global.textlightcolors);
            //////////////////////////////////////////
            custombtnsubmit.setBackgroundResource(R.drawable.light_menu_button);
            normalsubmitbtn.setBackgroundResource(R.drawable.light_menu_button);
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_log_activity);
        Spinner Buildings = findViewById(R.id.spinner);

        Spinner Rooms = findViewById(R.id.spinner2);

        this.setTitle("Location Log");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Global.item);
        Buildings.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Global.items);
        Rooms.setAdapter(adapter1);
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