package nyc.c4q.hakeemsackes_bramble.c4qweatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import nyc.c4q.hakeemsackes_bramble.c4qweatherapp.weather_api.ForcastClient;
import nyc.c4q.hakeemsackes_bramble.c4qweatherapp.weather_api.Period;

public class MainActivity extends AppCompatActivity {
    private ForcastClient forcastClient;
    private int tempType;


    ArrayList<Period> forecast;
    private final String baseUrl = "http://api.aerisapi.com/";
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forcastClient = new ForcastClient();
        forcastClient.connectToServer(baseUrl, getApplicationContext(), (RecyclerView) findViewById(R.id.forecast_recyclerview), tempType);
        Log.d("TAG", "onCreate: " + forecast);
        button = (Button) findViewById(R.id.temp_type_main);
        button.setText("Show Celsius");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (forcastClient.isReadyToChange()) {
                    tempType += 1;
                    tempType %= 2;
                    forcastClient.changeTempType(tempType);
                    if (tempType == 1) {
                        button.setText("Show Fahrenheit");
                    } else {
                        button.setText("Show Celsius");
                    }
                }
            }
        });
    }

}
