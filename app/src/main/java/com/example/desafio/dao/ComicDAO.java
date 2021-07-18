package com.example.desafio.dao;

import androidx.room.*;
import com.example.desafio.model.ComicToDB;

import java.util.List;

/**
 * Interface responsável por definir os métodos de CRUD utilizados pelo ROOM Database.
 */
@Dao
public interface ComicDAO {

    @Query("SELECT * FROM comic_cart")
    List<ComicToDB> getComicDB();

    @Query("DELETE FROM comic_cart")
    void deleteComicDB();

    @Insert
    void insertComicToDB(ComicToDB comic);

    @Update
    void updateComicToDB(ComicToDB comic);

    @Delete
    void deleteComicToDB(ComicToDB comic);
}
