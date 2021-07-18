package com.example.desafio.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.desafio.dao.ComicDAO;
import com.example.desafio.model.ComicToDB;

/**
 * Classe que define a instância do BD.
 */
@Database(entities = ComicToDB.class, exportSchema = false, version = 1)
public abstract class ComicDatabase extends RoomDatabase {
    private static final String DB_NAME = "cart_comics";
    private static ComicDatabase instance;

    public static synchronized ComicDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), ComicDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }

    public abstract ComicDAO comicDAO();
}
