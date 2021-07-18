package com.example.desafio.api;

import com.example.desafio.model.MarvelResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Interface responsável por definir o end-point utilizado na requisição.
 */
public interface MarvelDataService {

    @GET("/v1/public/comics?")
    Call<MarvelResponse> getComics(
        @Query("format") String format,
        @Query("formatType") String formatType,
        @Query("noVariants") String noVariants,
        @Query("orderBy") String orderBy,
        @Query("apikey") String apikey,
        @Query("hash") String hash,
        @Query("ts") String ts,
        @Query("limit") String limit,
        @Query("characters") String characters
    );
}
