package nyc.c4q.hakeemsackes_bramble.c4qweatherapp.WeatherApi;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by hakeemsackes-bramble on 8/4/17.
 */

public interface ForcastService {
    @GET("")
    Call<ForcastResponse> getData();
}

