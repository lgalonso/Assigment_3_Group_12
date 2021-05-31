package se.mau.group12.assigment3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import se.mau.group12.assigment3.database.AppDatabase;
import se.mau.group12.assigment3.database.DatabaseResources;
import se.mau.group12.assigment3.database.User;
import se.mau.group12.assigment3.database.UserDao;

public class RegisterActivity extends AppCompatActivity {
    AppDatabase db;
    User user;
    UserDao userDao;
    SharedPreferences sp;

    Button loginButton;
    EditText name, surname, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sp = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

        initComponents();

        db = AppDatabase.getInstance(RegisterActivity.this);
        DatabaseResources databaseResources = new DatabaseResources();
        databaseResources.loadResources(RegisterActivity.this);

        user = new User();
        userDao = db.userDao();

    }

    private void initComponents() {
        name = findViewById(R.id.register_username_input);
        surname = findViewById(R.id.register_lastName_input);
        email = findViewById(R.id.register_email_input);
        password = findViewById(R.id.register_password_input);

        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setName(name.getText().toString());
                user.setSurname(surname.getText().toString());
                user.setEmail(email.getText().toString());
                user.setPassword(password.getText().toString());

                userDao.insert(user);

                user = db.userDao().findByEmailPassword(user.getEmail(), user.getPassword());
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name", user.getName());
                editor.putString("surname", user.getSurname());
                editor.putString("user_id", String.valueOf(user.getUid()));
                editor.commit();

                Toast.makeText(getApplicationContext(), "user registred...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}