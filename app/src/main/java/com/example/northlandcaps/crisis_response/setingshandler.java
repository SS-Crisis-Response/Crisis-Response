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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Text;

public class setingshandler extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setingshandler);
        this.setTitle("Settings");
        SeekBar seekbar = findViewById(R.id.darknessbar);
        final TextView progresstext = findViewById(R.id.progresstext);
        final ConstraintLayout settings =findViewById(R.id.settingspage);
        final Switch animationon = findViewById(R.id.AnimationOnButton);
        final TextView ToggleAnimationText = findViewById(R.id.ToggleAnimationText);
        seekbar.setProgress(Global.themetype);
        final Button changepassword = findViewById(R.id.changepassword);
        if (Global.themetype ==0){
            //dark theme
            settings.setBackground(Global.DarkGD);
            progresstext.setTextColor(Global.textdarkcolors);
            progresstext.setText("Dark colors");
            ToggleAnimationText.setTextColor(Global.textdarkcolors);
            changepassword.setBackgroundResource(R.drawable.dark_menu_buttons);
            changepassword.setTextColor(Global.textdarkcolors);
        }else if (Global.themetype ==1){
            //normal theme
            settings.setBackground(Global.NormalGD);
            ToggleAnimationText.setTextColor(Global.textnormalcolors);
            progresstext.setTextColor(Global.textnormalcolors);
            progresstext.setText("Normal colors");
            changepassword.setBackgroundResource(R.drawable.menu_buttons);
            changepassword.setTextColor(Global.textnormalcolors);
        }else if (Global.themetype==2){
            //light theme
            settings.setBackground(Global.LightGD);
            progresstext.setTextColor(Global.textlightcolors);
            ToggleAnimationText.setTextColor(Global.textlightcolors);
            progresstext.setText("Light colors");
            changepassword.setBackgroundResource(R.drawable.light_menu_button);
            changepassword.setTextColor(Global.textlightcolors);
        }
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar.setProgress(progress);
                System.out.println(progress);
                if (progress==1){
                    Global.themetype = 1;
                    settings.setBackground(Global.NormalGD);
                    progresstext.setTextColor(Global.textnormalcolors);
                    progresstext.setText("Normal colors");
                    ToggleAnimationText.setTextColor(Global.textnormalcolors);
                    changepassword.setBackgroundResource(R.drawable.menu_buttons);
                    changepassword.setTextColor(Global.textnormalcolors);
                }else if(progress ==2){
                    Global.themetype = 2;
                    settings.setBackground(Global.LightGD);
                    progresstext.setTextColor(Global.textlightcolors);
                    ToggleAnimationText.setTextColor(Global.textlightcolors);
                    progresstext.setText("Light colors");
                    changepassword.setBackgroundResource(R.drawable.light_menu_button);
                    changepassword.setTextColor(Global.textlightcolors);
                }else if(progress==0){
                    Global.themetype = 0;
                    settings.setBackground(Global.DarkGD);
                    progresstext.setTextColor(Global.textdarkcolors);
                    ToggleAnimationText.setTextColor(Global.textdarkcolors);
                    progresstext.setText("Dark colors");
                    changepassword.setBackgroundResource(R.drawable.dark_menu_buttons);
                    changepassword.setTextColor(Global.textdarkcolors);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        if (Global.animationon){
            animationon.toggle();
        }
        animationon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.animationon){
                    Global.animationon=false;
                }else if (!Global.animationon){
                    Global.animationon=true;
                }else{
                    Log.d("Global Animation: ", String.valueOf(Global.animationon));
                }
            }
        });
    }
}
