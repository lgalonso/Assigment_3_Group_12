package se.mau.group12.assigment3.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import se.mau.group12.assigment3.HomeActivity;
import se.mau.group12.assigment3.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TextView textViewtitle, numberSessionDone, textViewDateDay,textViewTemperatureDay, textWelcomeMessage;
    private Button btnNext;
    private ImageView imageweather;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        textViewtitle = root.findViewById(R.id.textViewTitleHome);
        btnNext = root.findViewById(R.id.buttonNextHome);
        numberSessionDone=root.findViewById(R.id.numberofSessionDone);
        textViewDateDay=root.findViewById(R.id.textViewDateDay);
        textViewTemperatureDay=root.findViewById(R.id.temperatureText);
        textWelcomeMessage = root.findViewById(R.id.WelcomeMessageWeather);

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

            }
        });
        return root;
    }
}