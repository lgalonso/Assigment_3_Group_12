package se.mau.group12.assigment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import se.mau.group12.assigment3.database.AppDatabase;
import se.mau.group12.assigment3.database.DatabaseResources;
import se.mau.group12.assigment3.database.Exercise;
import se.mau.group12.assigment3.database.Training;

public class SessionsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerSessions recyclerSessions;
    TextView textViewTitle;
    Button souscribeButton;
    List<Exercise> session;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessions);

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
                //todo update database user training
                //add start date and training name
            }
        });


    }

    private void getSessionFromDatabase(String trainingName) {
        AppDatabase db = AppDatabase.getInstance(SessionsActivity.this);

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