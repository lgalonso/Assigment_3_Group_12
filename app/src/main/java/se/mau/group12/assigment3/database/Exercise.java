package se.mau.group12.assigment3.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Exercise {
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

    @ColumnInfo(name = "exercise_link")
    public String exercise_link;

    @ColumnInfo(name = "exercise_image")
    public String exercise_image;
}
