package nyc.c4q.hakeemsackes_bramble.c4qweatherapp.weather_api;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by hakeemsackes-bramble on 8/4/17.
 */

public class Response {


    @SerializedName("periods")
    private ArrayList<Period> periods;

    public ArrayList<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(ArrayList<Period> periods) {
        this.periods = periods;
    }
}
