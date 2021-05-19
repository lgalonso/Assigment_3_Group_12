package se.mau.group12.assigment3.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TrainingDao {
    @Query("SELECT * FROM training")
    List<Training> getAll();

    @Insert
    void insert(Training training);

    @Delete
    void delete(Training training);
}
