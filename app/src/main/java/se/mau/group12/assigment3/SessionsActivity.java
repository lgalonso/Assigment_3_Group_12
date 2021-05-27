package se.mau.group12.assigment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import se.mau.group12.assigment3.database.AppDatabase;
import se.mau.group12.assigment3.database.DatabaseResources;
import se.mau.group12.assigment3.database.Exercise;
import se.mau.group12.assigment3.database.Training;
import se.mau.group12.assigment3.database.User;

public class SessionsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerSessions recyclerSessions;
    TextView textViewTitle;
    Button souscribeButton;
    List<Exercise> session;
    SharedPreferences sp;
    AppDatabase db = AppDatabase.getInstance(SessionsActivity.this);
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessions);

        sp = getApplicationContext().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

        session = new ArrayList<Exercise>();

        textViewTitle = findViewById(R.id.TitleTrainingChoose);
        recyclerView = findViewById(R.id.recyclerViewSessionsTraining);

        souscribeButton = findViewById(R.id.Button_souscribe);

        getSessionFromDatabase(getIntent().getStringExtra("Title"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerSessions = new RecyclerSessions(session);
        recyclerView.setAdapter(recyclerSessions);

        // from the intent we get the name of the training
        String title = getIntent().getStringExtra("Title");
        textViewTitle.setText(title);

        souscribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo message user that subscription was successful
                Training training = new Training();
                training = getTraining(title);
                Date currentTime = Calendar.getInstance().getTime();
                //String dateFormatted = formatter.format(currentTime);

                User user = new User();
                user = db.userDao().findById(Integer.parseInt(sp.getString("user_id", "")));
                db.userDao().setTrainingById(training.getName(), currentTime, user.getUid());
            }
        });


    }

    private Training getTraining(String trainingName) {
        Training training = new Training();

        switch (trainingName) {
            case "ABS":
                training = db.trainingDao().getTrainingByName("Abs workout");
                break;
            case "LEGS":
                training = db.trainingDao().getTrainingByName("Legs Workout");
                break;
            case "FULL":
                training = db.trainingDao().getTrainingByName("Full Body workout");
                break;
            case "SHOU":
                training = db.trainingDao().getTrainingByName("Shoulders and back workout");
                break;
        }

        return training;
    }

    private void getSessionFromDatabase(String trainingName) {
        AppDatabase db = AppDatabase.getInstance(SessionsActivity.this);

        Training training = getTraining(trainingName);

        session.add(
                db.exerciseDao().getExerciseByName(
                        training.getExercise_key_1()
                )
        );
        session.add(
                db.exerciseDao().getExerciseByName(
                        training.getExercise_key_2()
                )
        );
        session.add(
                db.exerciseDao().getExerciseByName(
                        training.getExercise_key_3()
                )
        );
    }
}