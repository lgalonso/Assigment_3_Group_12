package se.mau.group12.assigment3.ui.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import se.mau.group12.assigment3.DetailsSessionActivity;
import se.mau.group12.assigment3.HomeActivity;
import se.mau.group12.assigment3.R;
import se.mau.group12.assigment3.database.AppDatabase;
import se.mau.group12.assigment3.database.Exercise;
import se.mau.group12.assigment3.database.Training;
import se.mau.group12.assigment3.database.User;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TextView textViewtitle, numberSessionDone, textViewDateDay,textViewTemperatureDay, textWelcomeMessage, textHelloname;
    TextView exerciseTittle;
    private Button btnNext;
    private ImageView imageweather;
    View root_aux;
    SharedPreferences sp;
    AppDatabase db;
    TextView exerciseOfDay,numberOfSessions;
    LinearLayout exerciseContainer;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        root_aux = root;

        db = AppDatabase.getInstance(root.getContext());

        sp = this.getActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

        numberOfSessions = root.findViewById(R.id.numberofSessionDone);
        exerciseOfDay = root.findViewById(R.id.linearLayout2);
        exerciseContainer = root.findViewById(R.id.textView6);

        exerciseTittle = root.findViewById(R.id.textViewTitleHome);
        btnNext = root.findViewById(R.id.buttonNextHome);
        //btnNext.setVisibility(View.VISIBLE);
        setExerciseOnHome();
        textViewtitle = root.findViewById(R.id.textViewTitleHome);
        numberSessionDone=root.findViewById(R.id.numberofSessionDone);
        textViewDateDay=root.findViewById(R.id.textViewDateDay);
        textViewTemperatureDay=root.findViewById(R.id.temperatureText);
        textWelcomeMessage = root.findViewById(R.id.WelcomeMessageWeather);
        textHelloname= root.findViewById(R.id.textHelloName);

        imageweather =root.findViewById(R.id.imageWeather);
        String temperature = ((HomeActivity)getActivity()).get_temp();
        String weather = ((HomeActivity)getActivity()).get_weather();
        textViewTemperatureDay.setText(temperature);
        Calendar calendar;
        calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat;
        dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy" );
        String date = dateFormat.format(calendar.getTime());
        textViewDateDay.setText(date);
        textHelloname.setText("Hello " + HomeActivity.firstname);
        switch (weather)
        {
            case "Clouds":
                imageweather.setImageResource(R.drawable.clouds);
                textWelcomeMessage.setText("Nice weather today. Time to get up!!");
                break;
            case "Clear":
                imageweather.setImageResource(R.drawable.sun);
                textWelcomeMessage.setText("Go outside to training it's a sunny day !");
                //text
                break;
            case "Snow":
                imageweather.setImageResource(R.drawable.snow);
                textWelcomeMessage.setText("An inside training it's also good for the muscle !");
                break;
            case "Rain":
                imageweather.setImageResource(R.drawable.rain);
                textWelcomeMessage.setText("Run in the rain never killed anyone !");
                break;
            case "Thunderstorm":
                imageweather.setImageResource(R.drawable.thunderstorm);
                textWelcomeMessage.setText("An inside training it's also good for the muscle !");
                break;
            default:
                imageweather.setImageResource(R.drawable.cloudswithsun);
                textWelcomeMessage.setText("Go outside to training !");
                break;
        }


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OPEN DETAILSSESSIONACTIVITY WITH GOOD SESSION ( USE DATABASE)
                Intent intent = new Intent(root_aux.getContext(), DetailsSessionActivity.class);
                intent.putExtra("exercise", exerciseTittle.getText().toString());
                root_aux.getContext().startActivity(intent);
            }
        });
        return root;
    }

    private void setExerciseOnHome() {
        User user = db.userDao().findById(Integer.parseInt(sp.getString("user_id", "-1")));
        if(user.getTraining_key_1() == null) {
            exerciseContainer.setVisibility(View.INVISIBLE);
            numberOfSessions.setVisibility(View.INVISIBLE);
            exerciseOfDay.setVisibility(View.INVISIBLE);
        } else {
            exerciseContainer.setVisibility(View.VISIBLE);
            numberOfSessions.setVisibility(View.VISIBLE);
            exerciseOfDay.setVisibility(View.VISIBLE);
            Training training = db.trainingDao().getTrainingByName(user.getTraining_key_1());
            Exercise exercise = db.exerciseDao().getExerciseByName(training.getExercise_key_1());

            exerciseTittle.setText(exercise.getName());

        }

    }
}