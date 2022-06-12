package com.example.bnvtest;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bnvtest.model.Category;
import com.example.bnvtest.model.Product;

import java.util.List;

public class PCardAdapter extends RecyclerView.Adapter<PCardAdapter.ViewHolder> {
    private List<Product> items;
    int user;
    public PCardAdapter(List<Product> items, int user){
        this.items = items;
        this.user = user;
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
    public void onBindViewHolder(@NonNull PCardAdapter.ViewHolder holder, int position) {
        final Product product = items.get(position);
        CardView cardView = holder.cardView;
        TextView txt = cardView.findViewById(R.id.CardText);
        ImageView img = cardView.findViewById(R.id.CardImage);

        Glide.with(cardView.getContext()).load(product.getProductImage()).into(img);
        txt.setText(product.getProductName());
        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(cardView.getContext(), ProductDetailsActivity.class);
                intent.putExtra("SELECTED", items.get(holder.getAdapterPosition()).getProductId());
                intent.putExtra("USER", user);
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
