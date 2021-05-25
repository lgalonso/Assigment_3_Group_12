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


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OPEN DETAILSSESSIONACTIVITY WITH GOOD SESSION ( USE DATABASE)

            }
        });
        return root;
    }
}