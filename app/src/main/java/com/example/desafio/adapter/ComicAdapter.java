package com.example.desafio.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.desafio.R;
import com.example.desafio.model.Comic;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Adaptador utilizado para listar os quadrinhos requisitados.
 */
public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.MyViewHolder> {
    private final List<Comic> comicList;

    public ComicAdapter(List<Comic> comicList){
        this.comicList = comicList;

    }

    @NonNull
    @Override
    public ComicAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.comic_item_horizontal, parent, false);
        return new MyViewHolder(itemList);
    }

    /**
     * No método abaixo eu estou colorindo o nome do título com um tom de amarelo,
     * caso o quadrinho seja raro.
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull ComicAdapter.MyViewHolder holder, int position) {
        final Comic comic = comicList.get(position);

        if (comic.isRare()){
            holder.comicTitle.setText(comic.getTitle());
            holder.comicTitle.setTextColor(Color.parseColor("#DAA520"));
        }else {
            holder.comicTitle.setText(comic.getTitle());
        }

        String url = comic.getThumbnail().getPath()+"."+comic.getThumbnail().getExtension();
        Picasso.get()
                .load(url)
                .fit()
                .centerCrop()
                .into(holder.comicCover);

    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView comicCover;
        TextView comicTitle;
        View comicButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            comicCover = itemView.findViewById(R.id.coverImageHz);
            comicTitle = itemView.findViewById(R.id.titleComicHz);
            comicButton = itemView.findViewById(R.id.comicButton);
        }
    }
}
