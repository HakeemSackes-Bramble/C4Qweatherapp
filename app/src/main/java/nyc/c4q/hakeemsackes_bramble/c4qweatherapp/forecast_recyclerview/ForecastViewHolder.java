package nyc.c4q.hakeemsackes_bramble.c4qweatherapp.forecast_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.hakeemsackes_bramble.c4qweatherapp.R;
import nyc.c4q.hakeemsackes_bramble.c4qweatherapp.weather_api.Period;

/**
 * Created by hakeemsackes-bramble on 8/4/17.
 */

class ForecastViewHolder extends RecyclerView.ViewHolder {
    private TextView date;
    private TextView highTemp;
    private TextView lowTemp;

    public ForecastViewHolder(View itemView) {
        super(itemView);
        date = (TextView) itemView.findViewById(R.id.date);
        highTemp = (TextView) itemView.findViewById(R.id.hi_temp);
        lowTemp = (TextView) itemView.findViewById(R.id.low_temp);
    }

    public void bind(Period day, int tempType) {
        date.setText(day.getValidTime().substring(0, 10));
        if (tempType == 0) {
            highTemp.setText("HIGH " + day.getMaxTempF() + " F");
            lowTemp.setText("LOW " + day.getMinTempF() + " F");
        } else {
            highTemp.setText("HIGH " + day.getMaxTempC() + " C");
            lowTemp.setText("LOW " + day.getMinTempC() + " C");
        }
    }
}
