package se.mau.group12.assigment3.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE name LIKE :first AND " +
            "surname LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Query("SELECT * FROM user WHERE uid LIKE :uid LIMIT 1")
    User findById(int uid);

    @Query("SELECT * FROM user WHERE email LIKE :email AND " +
            "password LIKE :password LIMIT 1")
    User findByEmailPassword(String email, String password);

    @Query("UPDATE user SET training_key_1 = :training_key_1, start_date = :start_date WHERE uid LIKE :uid ")
    User setTrainingById(String training_key_1, String start_date, int uid);

//    @Insert
//    void insertAll(User... users);

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);
}
