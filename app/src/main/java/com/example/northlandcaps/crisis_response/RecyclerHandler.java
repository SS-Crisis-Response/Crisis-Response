package com.example.northlandcaps.crisis_response;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerHandler extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "RecyclerHandler";
    private ArrayList<String>msettings = new ArrayList<>();

    public RecyclerHandler(ArrayList<String> msettings, Context context){
        msettings = settingname;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewholder extends RecyclerView.ViewHolder{
        TextView settingnames;
        ConstraintLayout RecyclerLayout;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            settingnames = itemView.findViewById(R.id.textinrecyclerview);
            RecyclerLayout = itemView.findViewById(R.id.Reclyclerlayout);
        }
    }
}
