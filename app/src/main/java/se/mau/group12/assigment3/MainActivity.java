package se.mau.group12.assigment3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaCodec;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import se.mau.group12.assigment3.ui.home.HomeFragment;

import se.mau.group12.assigment3.database.AppDatabase;
import se.mau.group12.assigment3.database.DatabaseResources;
import se.mau.group12.assigment3.database.User;
import se.mau.group12.assigment3.database.UserDao;

public class MainActivity extends AppCompatActivity {

    Button signInButton, createAccountButton;
    String temperature = "";
    String weather ="";
    AppDatabase db;
    TextView emailInput;
    TextView passwordInput;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWeatherAPI();

        sp = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);

        // Database and populate it with the db resources
        db = AppDatabase.getInstance(MainActivity.this);
        DatabaseResources databaseResources = new DatabaseResources();
        databaseResources.loadResources(MainActivity.this);

        emailInput = findViewById(R.id.login_email_input);
        passwordInput = findViewById(R.id.login_password_input);

        signInButton = findViewById(R.id.button_Sign_in);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CHECK EMAIL AND PASSWORD
                User user;
                user = db.userDao().findByEmailPassword(emailInput.getText().toString(), passwordInput.getText().toString());
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("name", user.getName());
                editor.putString("surname", user.getSurname());
                editor.putString("user_id", String.valueOf(user.getUid()));
                editor.commit();
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                intent.putExtra("temperature",temperature);
                intent.putExtra("weather",weather);
                startActivity(intent);
            }
        });

        createAccountButton = findViewById(R.id.button_create_account);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    public String getWeatherAPI()
    {
        Log.i("TAG", "getWeatherAPI: here");
        String apikey = "b4c34faf6d8d50697ddb34b2846b24a1";
        //api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
        String url="https://api.openweathermap.org/data/2.5/weather?q=malmo&appid=e8d6a48f8400dbc223c3f72c05341708";



        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Log.i("TAG", "onResponse: try");
                    JSONObject object = response.getJSONObject("main");
                    JSONArray object2 = response.getJSONArray("weather");
                    JSONObject jsonPart = object2.getJSONObject(0);
                    temperature = object.getString("temp");
                    weather = jsonPart.getString("main");
                    double temp = Double.parseDouble(temperature);
                    temp = temp - 273.15;
                    temp = (double) Math.round(temp * 100) / 100;
                    temperature = String. valueOf(temp);
                    Log.i("TAG", "onResponse: "+weather);
                    Log.i("TAG", "onResponse: "+temperature);
                } catch (JSONException e) {
                    Log.i("TAG", "onResponse: catch");
                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i("TAG", "onErrorResponse: "+error);
            }
        });
        queue.add(request);

        return temperature;
    }


}