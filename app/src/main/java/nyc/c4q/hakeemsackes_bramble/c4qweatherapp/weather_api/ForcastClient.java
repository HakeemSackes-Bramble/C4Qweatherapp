package nyc.c4q.hakeemsackes_bramble.c4qweatherapp.weather_api;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import nyc.c4q.hakeemsackes_bramble.c4qweatherapp.forecast_recyclerview.ForecastAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.ContentValues.TAG;

/**
 * Created by hakeemsackes-bramble on 8/4/17.
 */

public class ForcastClient {
    private final String baseUrl = "http://api.aerisapi.com/";
    private RecyclerView recyclerView;

    public ForcastClient() {
    }

    public ArrayList<Period> getWeatherPeriods() {
        return weatherPeriods;
    }

    private ArrayList<Period> weatherPeriods;


    public void connectToServer(String baseUrl, final Context context, final RecyclerView rv) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();
        ForcastService service = retrofit.create(ForcastService.class);
        Call<ForcastResponse> call = service.getData("hH0TcWuZYR0YGzn7dKIsz", "FJxrYMugwZvxYIiwUM27cw30zrbIgCIJJKzRYX1X");
        call.enqueue(new Callback<ForcastResponse>() {
            @Override
            public void onResponse(Call<ForcastResponse> call, Response<ForcastResponse> response) {
                ForcastResponse childCareResponse = response.body();
                weatherPeriods = childCareResponse.getPeriods();
                Log.d(TAG, "onResponse: " + weatherPeriods);
                recyclerView = rv;
                recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                recyclerView.setAdapter(new ForecastAdapter(weatherPeriods));
            }

            @Override
            public void onFailure(Call<ForcastResponse> call, Throwable t) {
                Log.d(TAG, "Failed to connect");
            }
        });
    }
}
