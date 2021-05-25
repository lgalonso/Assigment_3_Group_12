package se.mau.group12.assigment3.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import se.mau.group12.assigment3.HomeActivity;
import se.mau.group12.assigment3.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private String temperature = "init";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        final TextView textViewtemp = root.findViewById(R.id.tempview);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
                temperature = ((HomeActivity)getActivity()).get_temp();
                textViewtemp.setText(temperature);
            }
        });
        return root;
    }
    public void setTemp()
    {

    }

}