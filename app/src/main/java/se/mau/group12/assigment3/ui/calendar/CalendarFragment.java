package se.mau.group12.assigment3.ui.calendar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import se.mau.group12.assigment3.R;
import se.mau.group12.assigment3.RecyclerSessions;
import se.mau.group12.assigment3.RegisterActivity;
import se.mau.group12.assigment3.database.AppDatabase;
import se.mau.group12.assigment3.database.Exercise;
import se.mau.group12.assigment3.database.Training;
import se.mau.group12.assigment3.database.User;

import static java.time.temporal.ChronoUnit.DAYS;

public class CalendarFragment extends Fragment {
    private static final String TAG = "CalendarFragment";
    private CalendarViewModel calendarViewModel;

    private CalendarView calendar;
    RecyclerView recyclerView;
    RecyclerSessions recyclerSessions;
    List<Exercise> session;
    SharedPreferences sp;
    AppDatabase db;
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calendarViewModel =
                new ViewModelProvider(this).get(CalendarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_calendar, container, false);

        calendar = (CalendarView) root.findViewById(R.id.calendarView);
        recyclerView = root.findViewById(R.id.recyclerViewCalendar);

        sp = root.getContext().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

        db = AppDatabase.getInstance(root.getContext());

        session = new ArrayList<Exercise>();

        User user = db.userDao().findById(Integer.parseInt(sp.getString("user_id", "-1")));

        Training training = getTraining(user.getTraining_key_1());



        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
                            {
                                session.clear();
                                session.add(
                                        db.exerciseDao().getExerciseByName(
                                                training.getExercise_key_1()
                                        )
                                );
                                String Date = dayOfMonth + "-" + (month + 1) + "-" + year;

                                try {
                                    long numberOfDays = DAYS.between(user.getStart_date().toInstant(), formatter.parse(Date).toInstant());

                                    Log.d(TAG, "onSelectedDayChange NUM OF DAYS: " + numberOfDays);
                                    if(numberOfDays > 0 && numberOfDays%2 == 0) {
                                        session.add(
                                                db.exerciseDao().getExerciseByName(
                                                        training.getExercise_key_2()
                                                )
                                        );
                                    }

                                    if(numberOfDays > 0 && numberOfDays%3 == 0) {
//                                        session.add(
//                                                db.exerciseDao().getExerciseByName(
//                                                        training.getExercise_key_3()
//                                                )
//                                        );
                                    }
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                //todo update the fragment so it reloads the fragment
                                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                                recyclerSessions = new RecyclerSessions(session);
                                recyclerView.setAdapter(recyclerSessions);

                            }
                        });


        return root;
    }

    private Training getTraining(String trainingName) {
        Training training = new Training();

        training = db.trainingDao().getTrainingByName(trainingName);

        return training;
    }
}