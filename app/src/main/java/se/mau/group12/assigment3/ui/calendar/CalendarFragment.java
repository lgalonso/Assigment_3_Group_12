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

import se.mau.group12.assigment3.R;

public class CalendarFragment extends Fragment {

    private CalendarViewModel calendarViewModel;

    private CalendarView calendar;
    private TextView textViewtitle;
    private ImageView imageView;
    private  Button btnNext;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calendarViewModel =
                new ViewModelProvider(this).get(CalendarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_calendar, container, false);

        calendar = (CalendarView) root.findViewById(R.id.calendarView);
        textViewtitle = root.findViewById(R.id.textViewTitleCalendar);
        imageView = root.findViewById(R.id.imageCalendar);
        btnNext = root.findViewById(R.id.buttonNextCalendar);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                            @Override
                            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth)
                            {

                                String Date = dayOfMonth + "-" + (month + 1) + "-" + year;
                                //USE DATABASE TO CHANGE TITLE AND IMAGE
                                //get exercise name for the selected Date
                            }
                        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OPEN DETAILSSESSIONACTIVITY WITH GOOD SESSION (USE DATABASE)

            }
        });
        return root;
    }
}