package nyc.c4q.hakeemsackes_bramble.c4qweatherapp.weather_api;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import nyc.c4q.hakeemsackes_bramble.c4qweatherapp.forecast_recyclerview.ForecastAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hakeemsackes-bramble on 8/4/17.
 */

public class ForcastClient {
    private static final String baseUrl = "http://api.aerisapi.com/";
    private ForecastAdapter forecastAdapter;

    private RecyclerView recyclerView;
    private boolean isReadyToChange;

    public ForcastClient() {
    }

    public ArrayList<Period> getWeatherPeriods() {
        return weatherPeriods;
    }

    private static ArrayList<Period> weatherPeriods;

    public void connectToServer(String baseUrl, final Context context, final RecyclerView rv, final int tempType) {
        isReadyToChange = false;
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();
        ForecastService service = retrofit.create(ForecastService.class);
        Call<ForecastResponse> call = service.getData("hH0TcWuZYR0YGzn7dKIsz", "FJxrYMugwZvxYIiwUM27cw30zrbIgCIJJKzRYX1X");
        call.enqueue(new Callback<ForecastResponse>() {
            @Override
            public void onResponse(Call<ForecastResponse> call, Response<ForecastResponse> response) {
                ForecastResponse childCareResponse = response.body();
                weatherPeriods = childCareResponse.getResponses().get(0).getPeriods();
                System.out.println("onResponse: " + childCareResponse.getResponses().get(0).getPeriods());
                recyclerView = rv;
                recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                forecastAdapter = new ForecastAdapter(weatherPeriods, tempType, context);
                recyclerView.setAdapter(forecastAdapter);
                isReadyToChange = true;
            }

            @Override
            public void onFailure(Call<ForecastResponse> call, Throwable t) {
                //Log.d(TAG, "Failed to connect");
            }
        });
    }

    public boolean isReadyToChange() {
        return isReadyToChange;
    }

    public void changeTempType(int tempType) {

        forecastAdapter.setTempType(tempType);
        recyclerView.setAdapter(forecastAdapter);

    }
}
