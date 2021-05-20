package se.mau.group12.assigment3.ui.trainings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import se.mau.group12.assigment3.R;

public class TrainingsFragment extends Fragment {

    private TrainingsViewModel trainingsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        trainingsViewModel =
                new ViewModelProvider(this).get(TrainingsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_trainings, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        trainingsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}