package nyc.c4q.hakeemsackes_bramble.c4qweatherapp.forecast_recyclerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import nyc.c4q.hakeemsackes_bramble.c4qweatherapp.weather_api.Period;

import static nyc.c4q.hakeemsackes_bramble.c4qweatherapp.R.id;

/**
 * Created by hakeemsackes-bramble on 8/4/17.
 */

class ForecastViewHolder extends RecyclerView.ViewHolder {
    private TextView date;
    private TextView highTemp;
    private TextView lowTemp;
    private ImageView icon;

    public ForecastViewHolder(View itemView) {
        super(itemView);
        date = (TextView) itemView.findViewById(id.date);
        highTemp = (TextView) itemView.findViewById(id.hi_temp);
        lowTemp = (TextView) itemView.findViewById(id.low_temp);
        icon = (ImageView) itemView.findViewById(id.icon_weather);
    }

    public void bind(Period day, int tempType, Context context) {
        date.setText(day.getValidTime().substring(0, 10));
        InputStream is = null;
        try {
            is = context.getAssets().open(day.getIcon());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Drawable drw = Drawable.createFromStream(is, null);
        icon.setImageDrawable(drw);
        if (tempType == 0) {
            highTemp.setText("HIGH " + day.getMaxTempF() + " F");
            lowTemp.setText("LOW " + day.getMinTempF() + " F");
        } else {
            highTemp.setText("HIGH " + day.getMaxTempC() + " C");
            lowTemp.setText("LOW " + day.getMinTempC() + " C");
        }
    }
}
