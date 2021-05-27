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
    public int duration;

    @ColumnInfo(name = "difficulty")
    public int difficulty;

    @ColumnInfo(name = "video_id")
    public String video_id;

    @ColumnInfo(name = "video_timestamp")
    public int video_timestamp;

    @ColumnInfo(name = "image")
    public String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public int getVideo_timestamp() {
        return video_timestamp;
    }

    public void setVideo_timestamp(int video_timestamp) {
        this.video_timestamp = video_timestamp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getDate_interval() {
        return date_interval;
    }

    public void setDate_interval(int date_interval) {
        this.date_interval = date_interval;
    }

    @ColumnInfo(name = "date_interval")
    public int date_interval;
}
