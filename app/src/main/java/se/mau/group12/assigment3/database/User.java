package se.mau.group12.assigment3.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "surname")
    public String surname;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "weight")
    public Float weight;

    @ColumnInfo(name = "height")
    public Float height;

    @ColumnInfo(name = "calories")
    public Float calories;

    @ColumnInfo(name = "training_key_1")
    public String training_key_1;
}
