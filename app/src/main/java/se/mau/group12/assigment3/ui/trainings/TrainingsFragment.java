package se.mau.group12.assigment3.ui.trainings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import se.mau.group12.assigment3.DetailsSessionActivity;
import se.mau.group12.assigment3.R;

public class TrainingsFragment extends Fragment {

    private TrainingsViewModel trainingsViewModel;
    private ImageButton buttonAbs, buttonArms, buttonLegs, buttonFullBody, buttonShouldersAndBack;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        trainingsViewModel =
                new ViewModelProvider(this).get(TrainingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_trainings, container, false);

        buttonAbs = root.findViewById(R.id.Button_ABS);
        buttonArms = root.findViewById(R.id.Button_Arms);
        buttonLegs = root.findViewById(R.id.Button_Legs);
        buttonFullBody = root.findViewById(R.id.Button_FullBody);
        buttonShouldersAndBack = root.findViewById(R.id.Button_ShouldersAndBack);

        buttonAbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), DetailsSessionActivity.class);
                intent.putExtra("Title","ABS");
                startActivity(intent);
            }
        });

        buttonArms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        buttonLegs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        buttonFullBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        buttonShouldersAndBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return root;
    }
}