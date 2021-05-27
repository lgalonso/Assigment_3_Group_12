package se.mau.group12.assigment3.ui.stats;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import se.mau.group12.assigment3.R;

public class StatsFragment extends Fragment {

    private StatsViewModel statsViewModel;

    public static StatsFragment newInstance() {
        return new StatsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        statsViewModel =
                new ViewModelProvider(this).get(StatsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_stats, container, false);

        BarChart barChart = root.findViewById(R.id.barChart);
        ArrayList<BarEntry> visitors = new ArrayList<>();

        // DATA THAT WILL BE SHOWN IN THE GRAPH
        // USE DATA FROM THE DATABASE

        visitors.add(new BarEntry(2014,420));
        visitors.add(new BarEntry(2015,475));
        visitors.add(new BarEntry(2016,508));
        visitors.add(new BarEntry(2017,470));
        visitors.add(new BarEntry(2018,425));
        visitors.add(new BarEntry(2019,480));
        visitors.add(new BarEntry(2020,512));
        visitors.add(new BarEntry(2021,477));

        BarDataSet barDataSet = new BarDataSet(visitors,"Enter title here");
        barDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("SET TEXT HERE");
        barChart.animateY(2000);

        return root;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        statsViewModel = new ViewModelProvider(this).get(StatsViewModel.class);
        // TODO: Use the ViewModel
    }

}