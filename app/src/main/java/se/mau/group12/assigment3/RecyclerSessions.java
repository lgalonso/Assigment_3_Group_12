package se.mau.group12.assigment3;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import se.mau.group12.assigment3.database.Exercise;

public class RecyclerSessions extends RecyclerView.Adapter<RecyclerSessions.ViewHolder> {
    private static final String TAG = "RecyclerSessions";
    private Context context;
    private List<Exercise> sessions;
    TextView textViewTitle;

    public RecyclerSessions(List<Exercise> expenses) {
        this.sessions= expenses;
    }

    @NonNull
    @Override
    public RecyclerSessions.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        textViewTitle = view.findViewById(R.id.textViewTitle);

        ViewHolder vh = new ViewHolder(view);
        context = parent.getContext();

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerSessions.ViewHolder holder, int position) {
        Resources resources = context.getResources();

//        Log.d(TAG, "onBindViewHolder: "+sessions.get(position).getImage());
        String imageName = sessions.get(position).getImage();
        Log.d(TAG, "onBindViewHolder: "+imageName);
        if(imageName.contains(".png")){
            imageName = imageName.split("\\.")[0];
        }
        Log.d(TAG, "onBindViewHolder: "+imageName);

        int resId = resources.getIdentifier(imageName, "drawable", context.getPackageName());

        holder.title.setText(sessions.get(position).getName());
        holder.image.setImageDrawable(resources.getDrawable(resId));
        Button btnNext = holder.itemView.findViewById(R.id.buttonNextDetailsSession);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // OPEN DETAILS SESSION ACTIVITY WITH INFO OF THE SESSION
                // Create an intent to receive it on the DetailsSessionActivity
                Intent intent = new Intent(context, DetailsSessionActivity.class);
                intent.putExtra("exercise", holder.title.getText().toString());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return sessions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewTitle);
            image = itemView.findViewById(R.id.imageSession);
        }
    }
}
