package com.example.northlandcaps.crisis_response;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class EditBuilding extends AppCompatActivity {
    private static final String TAG = "EditBuilding";

    private ArrayList<String> mwords = new ArrayList<>();


    private void initbitmaps(){
        mwords.add("AAAAAAH");
        initrecyclerview();
    }
    private void initrecyclerview(){
        Log.d(TAG, "initrecyclerview: init recylcerview");
        RecyclerView recyclerView = findViewById(R.id.recylcerviewlayout);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
