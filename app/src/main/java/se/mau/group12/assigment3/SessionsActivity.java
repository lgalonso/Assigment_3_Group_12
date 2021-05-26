package se.mau.group12.assigment3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SessionsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerSessions recyclerSessions;
    TextView textViewTitle;

    List session; //USE DATABASE TO GET THE EXERCISES OF A TRAINING



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sessions);

        textViewTitle = findViewById(R.id.TitleTrainingChoose);
        recyclerView = findViewById(R.id.recyclerViewSessionsTraining);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerSessions = new RecyclerSessions(session);
        recyclerView.setAdapter(recyclerSessions);

        // from the intent we get the name of the training
        String title = getIntent().getStringExtra("Title");
        textViewTitle.setText(title);

    }
}