package nyc.c4q.hakeemsackes_bramble.c4qweatherapp.WeatherApi;

import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.attr.data;
import static android.content.ContentValues.TAG;

/**
 * Created by hakeemsackes-bramble on 8/4/17.
 */

public class ForcastClient {
    private static ArrayList<Period> weatherPeriods;

    public static void connectToServer(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        ForcastService service = retrofit.create(ForcastService.class);
        Call<ForcastResponse> call = service.getData();
        call.enqueue(new Callback<ForcastResponse>() {
            @Override
            public void onResponse(Call<ForcastResponse> call, Response<ForcastResponse> response) {

                /*
                HAKEEM: added an arraylist data field that will get populated here
                 */

                ForcastResponse childCareResponse = response.body();
                weatherPeriods = response.body().getPeriods();
                System.out.println(data);



            }

            @Override
            public void onFailure(Call<ForcastResponse> call, Throwable t) {
                Log.d(TAG,"Failed to connect");
            }
        });
    }
}
