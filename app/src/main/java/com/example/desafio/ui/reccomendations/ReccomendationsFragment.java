package com.example.desafio.ui.reccomendations;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.desafio.R;
import com.example.desafio.adapter.ComicAdapter;
import com.example.desafio.helper.RecyclerItemClickListener;
import com.example.desafio.helper.RetrofitConfig;
import com.example.desafio.model.Comic;
import com.example.desafio.model.MarvelResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


public class ReccomendationsFragment extends Fragment {

    private NavController navController;
    private RecyclerView recyclerAvengers;
    private RecyclerView recyclerCaptain;
    private RecyclerView recyclerSpider;
    private RecyclerView recyclerIron;
    private RecyclerView recyclerXmen;

    private List<Comic> avengersList    = new ArrayList<>();
    private List<Comic> captainList     = new ArrayList<>();
    private List<Comic> pantherList     = new ArrayList<>();
    private List<Comic> ironList        = new ArrayList<>();
    private List<Comic> xmenList        = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        navController = Navigation.findNavController(Objects.requireNonNull(getActivity()), R.id.nav_host_fragment);

        recyclerAvengers    = view.findViewById(R.id.recyclerAvengers);
        recyclerCaptain     = view.findViewById(R.id.recyclerCaptain);
        recyclerSpider      = view.findViewById(R.id.recyclerSpider);
        recyclerIron        = view.findViewById(R.id.recyclerIron);
        recyclerXmen        = view.findViewById(R.id.recyclerXmen);

        generateComics("1009165");
        generateComics("1009220");
        generateComics("1009187");
        generateComics("1009368");
        generateComics("1009726");

        super.onViewCreated(view, savedInstanceState);
    }

    private void configurarRecyclerAvengers() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        ComicAdapter comicAdapter = new ComicAdapter(avengersList);
        recyclerAvengers.setLayoutManager(layoutManager);
        recyclerAvengers.setHasFixedSize(true);
        recyclerAvengers.setAdapter(comicAdapter);
        recyclerAvengers.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerAvengers, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("comic", avengersList.get(position));
                navController.navigate(R.id.detailsFragment, bundle);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
    }

    private void configurarRecyclerCaptain() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        ComicAdapter comicAdapter = new ComicAdapter(captainList);
        recyclerCaptain.setLayoutManager(layoutManager);
        recyclerCaptain.setHasFixedSize(true);
        recyclerCaptain.setAdapter(comicAdapter);
        recyclerCaptain.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerCaptain, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("comic", captainList.get(position));
                navController.navigate(R.id.detailsFragment, bundle);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
    }

    private void configurarRecyclerSpider() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        ComicAdapter comicAdapter = new ComicAdapter(pantherList);
        recyclerSpider.setLayoutManager(layoutManager);
        recyclerSpider.setHasFixedSize(true);
        recyclerSpider.setAdapter(comicAdapter);
        recyclerSpider.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerSpider, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("comic", pantherList.get(position));
                navController.navigate(R.id.detailsFragment, bundle);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));
    }

    private void configurarRecyclerIron() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        ComicAdapter comicAdapter = new ComicAdapter(ironList);
        recyclerIron.setLayoutManager(layoutManager);
        recyclerIron.setHasFixedSize(true);
        recyclerIron.setAdapter(comicAdapter);
        recyclerIron.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerIron, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("comic", ironList.get(position));
                navController.navigate(R.id.detailsFragment, bundle);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));

    }

    private void configurarRecyclerXmen() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        ComicAdapter comicAdapter = new ComicAdapter(xmenList);
        recyclerXmen.setLayoutManager(layoutManager);
        recyclerXmen.setHasFixedSize(true);
        recyclerXmen.setAdapter(comicAdapter);
        recyclerXmen.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerXmen, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("comic", xmenList.get(position));
                navController.navigate(R.id.detailsFragment, bundle);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));

    }

    /**
     * Método utilizado para realizar a requisição.
     * @param idCharacter código identificador dos hérois.
     */
    private void generateComics(String idCharacter){
        final String format = "comic";
        final String formatType = "comic";
        final String noVariants = "true";
        final String orderBy = "-focDate";
        final String apikey = "92f79cac588bec5ad17b4c6418bd08b8";
        final String hash = "080618a1d76819e761d0f407dce2b525";
        final String ts = "marvelapi";
        final String limit = "10";

        Call<MarvelResponse> call= RetrofitConfig.marvelDataService().getComics(format, formatType, noVariants, orderBy, apikey, hash, ts, limit, idCharacter);
        call.enqueue(new Callback<MarvelResponse>() {
            @Override
            @EverythingIsNonNull
            public void onResponse(Call<MarvelResponse> call, Response<MarvelResponse> response) {
                if (response.code() == 200){
                    MarvelResponse marvelResponse = response.body();
                    assert marvelResponse != null;
                    switch (idCharacter){
                        case "1009165":
                            avengersList = defineRareStatusAndSetList(marvelResponse.getData().getResults());
                            configurarRecyclerAvengers();
                            break;
                        case "1009220":
                            captainList = defineRareStatusAndSetList(marvelResponse.getData().getResults());
                            configurarRecyclerCaptain();
                            break;
                        case "1009187":
                            pantherList = defineRareStatusAndSetList(marvelResponse.getData().getResults());
                            configurarRecyclerSpider();
                            break;
                        case "1009368":
                            ironList = defineRareStatusAndSetList(marvelResponse.getData().getResults());
                            configurarRecyclerIron();
                            break;
                        default:
                            xmenList = defineRareStatusAndSetList(marvelResponse.getData().getResults());
                            configurarRecyclerXmen();
                            break;
                    }
                }else{
                    Toast.makeText(getActivity(), "Houve um erro na requisição.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            @EverythingIsNonNull
            public void onFailure(Call<MarvelResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Não houve resposta da API.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * Método utilizado para definir a raridade dos quadrinhos.
     * @param comicList
     * @return
     */
    private List<Comic> defineRareStatusAndSetList(List<Comic> comicList){
        List<Comic> comicWithRare = new ArrayList<>();

        int quantRare = (int) (comicList.size() * 0.12f);
        int indiceRandom = new Random().nextInt(comicList.size());
        int contRare = 0;
        for(int i = 0; i < comicList.size(); i++){

            if(contRare < quantRare && i == indiceRandom){
                contRare++;
                comicList.get(i).setRare(true);
            }else {
                comicList.get(i).setRare(false);
            }

            comicWithRare.add(comicList.get(i));
        }

        return comicWithRare;
    }
}