package com.example.desafio.ui.details;

import android.os.Bundle;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.desafio.R;
import com.example.desafio.dao.ComicDAO;
import com.example.desafio.database.ComicDatabase;
import com.example.desafio.model.Comic;
import com.example.desafio.model.ComicToDB;
import com.squareup.picasso.Picasso;

public class DetailsFragment extends Fragment {

    private Comic comic;
    private ImageView comicDetailsImage;
    private TextView comicDetailsTitle;
    private TextView comicDetailsPrice;
    private TextView comicDetailsDescription;
    private Spinner spinner;
    private Button addToCart;
    private ComicDAO comicDAO;
    private ComicToDB comicToDB;


    public DetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ComicDatabase database = ComicDatabase.getInstance(getContext());
        comicDAO = database.comicDAO();
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        assert getArguments() != null;
        comic = (Comic) getArguments().getSerializable("comic");

        comicDetailsImage = view.findViewById(R.id.comicDetailsImage);
        Picasso.get()
                .load(comic.getThumbnail().getPath()+"."+comic.getThumbnail().getExtension())
                .fit()
                .centerInside()
                .into(comicDetailsImage);

        comicDetailsTitle = view.findViewById(R.id.comicDetailsText);
        comicDetailsTitle.setText(comic.getTitle());

        comicDetailsPrice = view.findViewById(R.id.comicDetailsPrice);
        comicDetailsPrice.setText(comic.getPrices().get(0).getPrice().toString());

        comicDetailsDescription = view.findViewById(R.id.comicDetailsDescription);
        comicDetailsDescription.setText(comic.getDescription());

        spinner = view.findViewById(R.id.spinnerQuantBuy);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.quant_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        addToCart = view.findViewById(R.id.addToCartButton);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comicToDB = new ComicToDB();
                comicToDB.setTitle(comic.getTitle());
                comicToDB.setDescription(comic.getDescription());
                comicToDB.setPrice(comic.getPrices().get(0).getPrice() * Double.parseDouble(spinner.getSelectedItem().toString()));
                comicToDB.setThumbnail(comic.getThumbnail().getPath()+"."+comic.getThumbnail().getExtension());
                comicToDB.setRare(comic.isRare());
                comicToDB.setQuant(Integer.parseInt(spinner.getSelectedItem().toString()));
                saveToCart();
                Toast.makeText(getContext(), "Produto adicionado!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    /**
     * Classe utilizada pora persistir a informação do quadrinho no carrinho de compras.
     */
    private void saveToCart(){
        comicDAO.insertComicToDB(comicToDB);
    }

}