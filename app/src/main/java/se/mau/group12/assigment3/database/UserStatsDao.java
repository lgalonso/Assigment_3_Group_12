package se.mau.group12.assigment3.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserStatsDao {
    @Query("SELECT * FROM userStats")
    List<UserStats> getAll();

    @Insert
    void insert(UserStats userStats);

    @Delete
    void delete(UserStats userStats);
}
