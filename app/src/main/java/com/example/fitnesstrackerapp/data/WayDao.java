package com.example.fitnesstrackerapp.data;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
@Dao
public interface WayDao {

    @Insert
    void insert(Way way);

    @Query("SELECT * FROM way_table WHERE id=:id")
    Way getWay(int id);

    @Query("SELECT * FROM way_table")
    Way getAllWay();
}
