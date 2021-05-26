package se.mau.group12.assigment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import se.mau.group12.assigment3.database.AppDatabase;
import se.mau.group12.assigment3.database.DatabaseResources;
import se.mau.group12.assigment3.database.User;
import se.mau.group12.assigment3.database.UserDao;

public class MainActivity extends AppCompatActivity {

    Button signInButton, createAccountButton;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Database and populate it with the db resources
        db = AppDatabase.getInstance(MainActivity.this);
        DatabaseResources databaseResources = new DatabaseResources();
        databaseResources.loadResources(MainActivity.this);

        signInButton = findViewById(R.id.button_Sign_in);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        createAccountButton = findViewById(R.id.button_create_account);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}