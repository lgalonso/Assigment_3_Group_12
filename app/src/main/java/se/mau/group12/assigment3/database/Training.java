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
    public int duration;

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

    public String getTraining_image() {
        return training_image;
    }

    public void setTraining_image(String training_image) {
        this.training_image = training_image;
    }

    public String getExercise_key_1() {
        return exercise_key_1;
    }

    public void setExercise_key_1(String exercise_key_1) {
        this.exercise_key_1 = exercise_key_1;
    }

    public String getExercise_key_2() {
        return exercise_key_2;
    }

    public void setExercise_key_2(String exercise_key_2) {
        this.exercise_key_2 = exercise_key_2;
    }

    public String getExercise_key_3() {
        return exercise_key_3;
    }

    public void setExercise_key_3(String exercise_key_3) {
        this.exercise_key_3 = exercise_key_3;
    }

    public String getExercise_key_4() {
        return exercise_key_4;
    }

    public void setExercise_key_4(String exercise_key_4) {
        this.exercise_key_4 = exercise_key_4;
    }
}
