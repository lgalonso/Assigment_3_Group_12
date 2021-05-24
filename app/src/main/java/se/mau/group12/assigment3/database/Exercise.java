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

    @ColumnInfo(name = "video_id")
    public String video_id;

    @ColumnInfo(name = "video_timestamp")
    public int video_timestamp;

    @ColumnInfo(name = "image")
    public String image;

    @ColumnInfo(name = "date_interval")
    public int date_interval;
}
