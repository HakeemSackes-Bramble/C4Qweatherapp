package nyc.c4q.hakeemsackes_bramble.c4qweatherapp.forecast_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.hakeemsackes_bramble.c4qweatherapp.R;
import nyc.c4q.hakeemsackes_bramble.c4qweatherapp.weather_api.Period;

import static android.content.ContentValues.TAG;

/**
 * Created by hakeemsackes-bramble on 8/4/17.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastViewHolder> {

    private int tempType;
    List<Period> days;
    private Context context;


    public ForecastAdapter(List<Period> days, int tempType, Context context) {
        this.days = days;
        this.tempType = tempType;
        this.context = context;
    }

    @Override

    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.forcast_day_layout, parent, false);
        return new ForecastViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {
        Period day = days.get(position);
        holder.bind(day, tempType, context);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + days.size());
        if (days == null) {
            return 0;
        }
        return days.size();

    }

    public void setTempType(int tempType) {
        this.tempType = tempType;
    }

}
