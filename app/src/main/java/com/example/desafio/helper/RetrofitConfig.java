package com.example.desafio.helper;

import com.example.desafio.api.MarvelDataService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Classe responsável por configurar o Retrofit para o consumo da API.
 */
public class RetrofitConfig {

    private static final String BASE_URL = "https://gateway.marvel.com/v1/public/";

    private static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static MarvelDataService marvelDataService(){
        return getRetrofit().create(MarvelDataService.class);
    }
}
