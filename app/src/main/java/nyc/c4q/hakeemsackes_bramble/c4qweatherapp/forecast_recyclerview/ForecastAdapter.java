package nyc.c4q.hakeemsackes_bramble.c4qweatherapp.forecast_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.hakeemsackes_bramble.c4qweatherapp.R;
import nyc.c4q.hakeemsackes_bramble.c4qweatherapp.weather_api.Period;

/**
 * Created by hakeemsackes-bramble on 8/4/17.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastViewHolder> {
    List<Period> days;

    public ForecastAdapter(List<Period> days) {
        this.days = days;
    }

    @Override

    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.forcast_day_layout, parent, false);
        return new ForecastViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {
        Period day = days.get(position);
        holder.bind(day);
    }

    @Override
    public int getItemCount() {
        if(days == null){
            return 0;}
        return days.size();
    }
}
