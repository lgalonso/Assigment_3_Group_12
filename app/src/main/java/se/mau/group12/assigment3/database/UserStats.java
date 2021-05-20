package se.mau.group12.assigment3.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class UserStats {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "user_id")
    public int user_id;

    @ColumnInfo(name = "weight")
    public Float weight;

    @ColumnInfo(name = "height")
    public Float height;

    @ColumnInfo(name = "calories")
    public Float calories;

    @ColumnInfo(name = "date")
    public Date date;
}
