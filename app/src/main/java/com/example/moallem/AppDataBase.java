package com.example.moallem;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.moallem.Models.Videos;
import com.example.moallem.Models.VideosDao;

@Database(entities = {Videos.class},version = 1,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private static final String LOG_TAG = AppDataBase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "ClientMyDatabase";
    private static AppDataBase sInstance;

    public static AppDataBase getInstance(Context context){
        if (sInstance == null){
            synchronized (LOCK){
                Log.d(LOG_TAG,"Creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDataBase.class,AppDataBase.DATABASE_NAME)
                        .allowMainThreadQueries()
                        .build();
            }
        }
        Log.d(LOG_TAG,"Getting the database instance");
        return sInstance;
    }

    public abstract VideosDao videoDao();

}
