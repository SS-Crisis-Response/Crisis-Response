package com.example.northlandcaps.crisis_response;

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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setingshandler);

        this.setTitle("Settings");
        SeekBar seekbar = findViewById(R.id.darknessbar);
        final TextView progresstext = findViewById(R.id.progresstext);
        final ConstraintLayout settings =findViewById(R.id.settingspage);
        seekbar.setProgress(1);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setProgress(progress);
                System.out.println(progress);
                if (progress==1){
                    settings.setBackground(Global.NormalGD);
                    progresstext.setTextColor(Global.textnormalcolors);
                    setTheme(R.style.NormalTheme);
                }else if(progress ==0){

                }else if(progress==2){
                    settings.setBackground(Global.DarkGD);
                    progresstext.setTextColor(Global.textlightcolors);
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
