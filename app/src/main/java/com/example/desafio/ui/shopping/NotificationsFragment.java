package com.example.desafio.ui.shopping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.desafio.R;

import com.example.desafio.adapter.ComicShoppingAdapter;
import com.example.desafio.dao.ComicDAO;
import com.example.desafio.database.ComicDatabase;

import com.example.desafio.model.ComicToDB;


import java.util.List;
import java.util.Objects;

public class NotificationsFragment extends Fragment {

    public static final String COMUM = "COMUM";
    public static final String RARO = "RARO";
    private RecyclerView recyclerShopping;
    private List<ComicToDB> comicList;
    private ComicDAO comicDAO;
    private TextView total;
    private EditText editTextCupom;
    private Button applyCupom;
    private Button finalizarPedido;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        ComicDatabase database = ComicDatabase.getInstance(getContext());
        comicDAO = database.comicDAO();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(Objects.requireNonNull(getActivity()), R.id.nav_host_fragment);

        comicList = comicDAO.getComicDB();

        recyclerShopping = view.findViewById(R.id.recyclerShopping);

        total = view.findViewById(R.id.totalComics);
        total.setText(calculateTotal());

        editTextCupom = view.findViewById(R.id.editTextCupom);

        applyCupom = view.findViewById(R.id.buttonApplyCupom);
        applyCupom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total.setText(calculateDiscount(editTextCupom.getText().toString()));
            }
        });

        finalizarPedido = view.findViewById(R.id.buttonEndPedido);
        finalizarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comicDAO.deleteComicDB();
                comicList = null;
                navController.navigate(R.id.checkoutFragment);
            }
        });

        configurarRecyclerSearch();
    }

    private void configurarRecyclerSearch() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        ComicShoppingAdapter comicShoppingAdapter = new ComicShoppingAdapter(comicList);
        recyclerShopping.setLayoutManager(layoutManager);
        recyclerShopping.setHasFixedSize(true);
        recyclerShopping.setAdapter(comicShoppingAdapter);
    }


    private String calculateTotal(){
        double totalCompra = 0;
        for (ComicToDB c: comicList){
            totalCompra += c.getPrice();
        }

        return "U$ " + String.format("%.2f", (totalCompra));
    }

    private String calculateDiscount(String cupom){
        double totalCompra = 0;

        for (ComicToDB c: comicList){
            if (cupom.equals(COMUM)){
                if (!c.isRare()){
                    totalCompra += c.getPrice() - (0.10 * c.getPrice());
                }else{
                    totalCompra += c.getPrice();
                }
            }else if (cupom.equals(RARO)){
                totalCompra += c.getPrice() - (0.25 * c.getPrice());
            }else {
                totalCompra += c.getPrice();
            }

        }

        return "U$ " + String.format("%.2f", totalCompra);
    }

}