package com.example.northlandcaps.crisis_response;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.drawable.GradientDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class setingshandler extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Global.themetype == 1 ){
            setTheme(R.style.NormalTheme);
        }else if (Global.themetype ==2){
            setTheme(R.style.LightTheme);
        }else if (Global.themetype ==0){
            setTheme(R.style.DarkTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setingshandler);

        this.setTitle("Settings");
        SeekBar seekbar = findViewById(R.id.darknessbar);
        final TextView progresstext = findViewById(R.id.progresstext);
        final ConstraintLayout settings =findViewById(R.id.settingspage);
        if (Global.themetype ==0){
            settings.setBackground(Global.DarkGD);
            progresstext.setTextColor(Global.textlightcolors);
            progresstext.setText("Dark colors");
        }else if (Global.themetype ==1){
            settings.setBackground(Global.NormalGD);
            progresstext.setTextColor(Global.textnormalcolors);
            progresstext.setText("Normal colors");
        }else if (Global.themetype ==2){
            settings.setBackground(Global.LightGD);
            progresstext.setTextColor(Global.textdarkcolors);
            progresstext.setText("Light colors");
        }
        seekbar.setProgress(Global.themetype);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setProgress(progress);
                System.out.println(progress);
                if (progress==1){
                    Global.themetype = 1;
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(getIntent());
                    overridePendingTransition(0, 0);
                }else if(progress ==2){
                    Global.themetype = 2;
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(getIntent());
                    overridePendingTransition(0, 0);
                }else if(progress==0){
                    Global.themetype = 0;
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(getIntent());
                    overridePendingTransition(0, 0);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
