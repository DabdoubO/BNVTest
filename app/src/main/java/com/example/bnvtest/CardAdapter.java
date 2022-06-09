package com.example.bnvtest;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{
    private String[] captions;
    private int[] imageIds;

    public CardAdapter(String[] captions, int[] imageIds){
        this.captions = captions;
        this.imageIds = imageIds;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        TextView txt = cardView.findViewById(R.id.CardText);
        ImageView img = cardView.findViewById(R.id.CardImage);
        Drawable dr = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        txt.setText(captions[position]);
        img.setImageDrawable(dr);
        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(cardView.getContext(), ProductActivity.class);
                intent.putExtra("SELECTED", txt.getText());
                cardView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }
    }

}
