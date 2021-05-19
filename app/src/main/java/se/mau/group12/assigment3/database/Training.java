package se.mau.group12.assigment3.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Training {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "duration")
    public String duration;

    @ColumnInfo(name = "difficulty")
    public int difficulty;

    @ColumnInfo(name = "training_image")
    public String training_image;

    @ColumnInfo(name = "exercise_key_1")
    public String exercise_key_1;

    @ColumnInfo(name = "exercise_key_2")
    public String exercise_key_2;

    @ColumnInfo(name = "exercise_key_3")
    public String exercise_key_3;

    @ColumnInfo(name = "exercise_key_4")
    public String exercise_key_4;
}
