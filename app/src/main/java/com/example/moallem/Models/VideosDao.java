package com.example.moallem.Models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public abstract class VideosDao {

    @Query("SELECT * FROM videos")
    public abstract List<Videos> getAllItems();

    /*public interface StoreInfoDAO {
        @Query("SELECT * FROM items WHERE Items.GenericName || Items.TradeNameEn || Items.TradeNameNative like :searchStr ")
        List<Items> getFilteredItem(String searchStr);
    }*/

    @Query("SELECT * FROM videos WHERE Videos.VideoPath || Videos.VideoImagePath like :searchStr ")
    public abstract List<Videos> getFilteredItem(String searchStr);

    @Insert()
    public abstract void insertItems(Videos...Item);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public abstract void updateItems(Videos item);

    @Delete
    public abstract void deleteItems(Videos item);

    @Transaction
    public void insertAllList(List<Videos> itemsList) {
        for (int i = 0 ;i < itemsList.size();i++){
            insertItems(itemsList.get(i));
        }
    }
}
