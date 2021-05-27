package se.mau.group12.assigment3.ui.calendar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import se.mau.group12.assigment3.R;
import se.mau.group12.assigment3.RecyclerSessions;
import se.mau.group12.assigment3.database.Exercise;

public class CalendarFragment extends Fragment {

    private CalendarViewModel calendarViewModel;

    private CalendarView calendar;
    RecyclerView recyclerView;
    RecyclerSessions recyclerSessions;
    List<Exercise> session;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calendarViewModel =
                new ViewModelProvider(this).get(CalendarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_calendar, container, false);

        calendar = (CalendarView) root.findViewById(R.id.calendarView);
        recyclerView = root.findViewById(R.id.recyclerViewCalendar);

        session = new ArrayList<Exercise>();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerSessions = new RecyclerSessions(session);
        recyclerView.setAdapter(recyclerSessions);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                            @Override
                            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
                            {

                                String Date = dayOfMonth + "-" + (month + 1) + "-" + year;
                                //USE DATABASE TO CHANGE TITLE AND IMAGE
                                //todo get exercise name for the selected Date
                            }
                        });

        return root;
    }
}