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

import com.bumptech.glide.Glide;
import com.example.bnvtest.model.Category;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{

    private List<Category> items;

    public CardAdapter(List<Category> items){
        this.items = items;
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
        final Category category = items.get(position);
        CardView cardView = holder.cardView;
        TextView txt = cardView.findViewById(R.id.CardText);
        ImageView img = cardView.findViewById(R.id.CardImage);

        Glide.with(cardView.getContext()).load(category.getCatImage()).into(img);
        txt.setText(category.getCatName());
        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent;
                if (cardView.getContext().toString().contains("MainActivity"))
                    intent = new Intent(cardView.getContext(), ProductActivity.class);
                else
                    intent = new Intent(cardView.getContext(), ProductDetailsActivity.class);
                intent.putExtra("SELECTED", txt.getText());
                cardView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }
    }

}
