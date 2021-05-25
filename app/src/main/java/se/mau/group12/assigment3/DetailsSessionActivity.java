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

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.Locale;

public class DetailsSessionActivity extends YouTubeBaseActivity {

    TextView intropage, subintropage, fitonetitle, fitonedesc, timerValue, btnexercise;
    View divpage, bgprogress;
    ImageView imgtimer;
    LinearLayout fitone;
    Button btnStart;

    YouTubePlayerView youTubeVideo;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    private static final long START_TIME_IN_MILLIS = 300000;
    private CountDownTimer countDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_session);

        btnStart = findViewById(R.id.StartButton);

        timerValue = findViewById(R.id.timerValue);

        youTubeVideo = findViewById(R.id.youtube_view);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                /// REPLACE HERE WITH LINK FROM THE DATABASE
                String link = "a4NT5iBFuZs";
                int timeStamp = 0;

                youTubePlayer.loadVideo(link,timeStamp);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        youTubeVideo.initialize("AIzaSyAYdEGnQOYZHdlrn4rnx71AVqaC1m_6mHg",onInitializedListener);

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