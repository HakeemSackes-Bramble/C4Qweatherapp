package nyc.c4q.hakeemsackes_bramble.c4qweatherapp.weather_api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by hakeemsackes-bramble on 8/4/17.
 */

public interface ForcastService {
    @GET("forecasts/11101")
    Call<ForcastResponse> getData(@Query("client_id") String CLIENT_ID, @Query("client_secret") String CLIENT_SECRET);
}

