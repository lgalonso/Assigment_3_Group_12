package se.mau.group12.assigment3;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import se.mau.group12.assigment3.database.AppDatabase;
import se.mau.group12.assigment3.database.DatabaseResources;
import se.mau.group12.assigment3.database.User;
import se.mau.group12.assigment3.database.UserDao;

public class RegisterActivity extends AppCompatActivity {
    AppDatabase db;
    User user;
    UserDao userDao;

    Button loginButton;
    EditText name, surname, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = AppDatabase.getInstance(RegisterActivity.this);

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

                //Todo error handling

                user.setName(name.getText().toString());
                user.setSurname(surname.getText().toString());
                user.setEmail(email.getText().toString());
                user.setPassword(password.getText().toString());

                userDao.insert(user);

                //Todo intent to change activity
            }
        });
    }
}