package com.example.northlandcaps.crisis_response;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Recyclerhandler extends RecyclerView.Adapter<Recyclerhandler.ViewHolder>{
    private static final String TAG = "Recyclerhandler";

    private ArrayList<String> mwords = new ArrayList<>();
    private Context mContext;

    public Recyclerhandler(Context mContext,ArrayList<String> mwords) {
        this.mwords = mwords;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerviewlayout,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called.");
        viewHolder.recylcertext.setText(mwords.get(i));
        viewHolder.recyclerviewlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mwords.get(i));


            }
        });
    }

    @Override
    public int getItemCount() {
        return mwords.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView recylcertext;
        ConstraintLayout recyclerviewlayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recylcertext = itemView.findViewById(R.id.recylcertextview);
            recyclerviewlayout = itemView.findViewById(R.id.recylcerviewlayout);

        }
    }
}
