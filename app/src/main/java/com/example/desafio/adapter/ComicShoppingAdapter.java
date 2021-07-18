package com.example.desafio.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.desafio.R;
import com.example.desafio.model.ComicToDB;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Adaptador utilizado para listar os quadrinhos adicionados ao carrinho de compras.
 */
public class ComicShoppingAdapter extends RecyclerView.Adapter<ComicShoppingAdapter.ShoppingViewHolder> {

    private final List<ComicToDB> comicList;

    public ComicShoppingAdapter(List<ComicToDB> comicList) {
        this.comicList = comicList;
    }

    @NonNull
    @Override
    public ComicShoppingAdapter.ShoppingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_cart_item, parent, false);
        return new ShoppingViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoppingViewHolder holder, int position) {
        final ComicToDB comic = comicList.get(position);
        holder.textComicTitle.setText(comic.getTitle());
        holder.textComicPrice.setText(String.format("%.2f", comic.getPrice()));
        Picasso.get()
                .load(comic.getThumbnail())
                .fit()
                .centerInside()
                .into(holder.imageComicCart);
        holder.textComicQuant.setText("Quantidade: " + Integer.toString(comic.getQuant()));
    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }

    public static class ShoppingViewHolder extends RecyclerView.ViewHolder{

        ImageView imageComicCart;
        TextView textComicTitle;
        TextView textComicPrice;
        TextView textComicQuant;

        public ShoppingViewHolder(@NonNull View itemView) {
            super(itemView);

            imageComicCart = itemView.findViewById(R.id.imageComicCart);
            textComicTitle = itemView.findViewById(R.id.textTitleCart);
            textComicPrice = itemView.findViewById(R.id.textPriceCart);
            textComicQuant = itemView.findViewById(R.id.textQuantCart);
        }
    }
}
