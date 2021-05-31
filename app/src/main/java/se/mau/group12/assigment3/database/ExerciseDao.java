package se.mau.group12.assigment3.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ExerciseDao {
    @Query("SELECT * FROM exercise")
    List<Exercise> getAll();

    @Query("SELECT * FROM exercise Where name LIKE :name")
    Exercise getExerciseByName(String name);

    @Insert
    void insert(Exercise exercise);

    @Delete
    void delete(Exercise exercise);
}
