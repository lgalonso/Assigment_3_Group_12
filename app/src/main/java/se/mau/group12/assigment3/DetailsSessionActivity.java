package se.mau.group12.assigment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class DetailsSessionActivity extends AppCompatActivity {

    TextView timerValue, title, description, timeSession;
    ImageView imgSession;
    LinearLayout fitone;
    Button btnStart;

    private static final long START_TIME_IN_MILLIS = 300000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_session);

        btnStart = findViewById(R.id.StartButton);

        imgSession = findViewById(R.id.imageSession);

        timerValue = findViewById(R.id.timerValue);
        description = findViewById(R.id.descriptionDetailsSession);
        timeSession = findViewById(R.id.timeDetailsSession);
        title= findViewById(R.id.titleDetailsSession);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startStop();

            }
        });

    }

    public void startStop(){
        if (mTimerRunning) {
            stopTimer();
        }else {
            startTimer();
        }
    }
    private void startTimer(){
        countDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDowntText();
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "Congratulations!", Toast.LENGTH_SHORT).show();
            }
        }.start();
        btnStart.setText("PAUSE");
        mTimerRunning = true;
    }

    public void stopTimer(){
        countDownTimer.cancel();
        btnStart.setText("START");
        mTimerRunning=false;
    }

    private void updateCountDowntText(){
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeft = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timerValue.setText(timeLeft);
    }
}