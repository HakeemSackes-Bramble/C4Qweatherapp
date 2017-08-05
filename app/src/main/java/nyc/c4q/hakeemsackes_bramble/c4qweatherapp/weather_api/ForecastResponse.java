package nyc.c4q.hakeemsackes_bramble.c4qweatherapp.weather_api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hakeemsackes-bramble on 8/5/17.
 */

class ForecastResponse {
    @SerializedName("response")
    List<Response> responses;

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }
}
