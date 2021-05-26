package se.mau.group12.assigment3;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class RecyclerSessions extends RecyclerView.Adapter<RecyclerSessions.ViewHolder> {

    private List sessions; // CHANGE WITH DATABASE
    TextView textViewTitle;

    //Todo on create query db to retrieve a list of exercises of a given training
    public RecyclerSessions(List expenses) {
        this.sessions= expenses;
    }

    @NonNull
    @Override
    public RecyclerSessions.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        textViewTitle = view.findViewById(R.id.textViewTitle);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerSessions.ViewHolder holder, int position) {

        TextView textViewtitle = holder.itemView.findViewById(R.id.textViewTitle);
        ImageView imageView = holder.itemView.findViewById(R.id.imageSession);
        Button btnNext = holder.itemView.findViewById(R.id.buttonNextDetailsSession);



        // USE DATABASE TO SET TEXT
        //   ....


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // OPEN DETAILS SESSION ACTIVITY WITH INFO OF THE SESSION
                // Create an intent to receive it on the DetailsSessionActivity
            }
        });


    }

    @Override
    public int getItemCount() {
        return sessions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
