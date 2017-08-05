package nyc.c4q.hakeemsackes_bramble.c4qweatherapp.weather_api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hakeemsackes-bramble on 8/4/17.
 */

public class Period {

    @SerializedName("timestamp")
    String timestamp;

    @SerializedName("validTime")
    String validTime;

    @SerializedName("dateTimeISO")
    String dateTimeISO;

    @SerializedName("maxTempC")
    String maxTempC;

    @SerializedName("maxTempF")
    String maxTempF;

    @SerializedName("minTempC")
    String minTempC;

    @SerializedName("minTempF")
    String minTempF;

    @SerializedName("icon")
    String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    public String getDateTimeISO() {
        return dateTimeISO;
    }

    public void setDateTimeISO(String dateTimeISO) {
        this.dateTimeISO = dateTimeISO;
    }

    public String getMaxTempC() {
        return maxTempC;
    }

    public void setMaxTempC(String maxTempC) {
        this.maxTempC = maxTempC;
    }

    public String getMaxTempF() {
        return maxTempF;
    }

    public void setMaxTempF(String maxTempF) {
        this.maxTempF = maxTempF;
    }

    public String getMinTempC() {
        return minTempC;
    }

    public void setMinTempC(String minTempC) {
        this.minTempC = minTempC;
    }

    public String getMinTempF() {
        return minTempF;
    }

    public void setMinTempF(String minTempF) {
        this.minTempF = minTempF;
    }


}
