package nyc.c4q.hakeemsackes_bramble.c4qweatherapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import nyc.c4q.hakeemsackes_bramble.c4qweatherapp.weather_api.ForcastClient;
import nyc.c4q.hakeemsackes_bramble.c4qweatherapp.weather_api.Period;

public class MainActivity extends AppCompatActivity {
    private ForcastClient forcastClient;
    ArrayList<Period> forecast;
    private RecyclerView recyclerView;
    private final String baseUrl = "http://api.aerisapi.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ForcastClient().connectToServer(baseUrl,getApplicationContext(),(RecyclerView) findViewById(R.id.forecast_recyclerview));


    }
}
