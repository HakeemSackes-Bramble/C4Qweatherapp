package nyc.c4q.hakeemsackes_bramble.c4qweatherapp.WeatherApi;

/**
 * Created by hakeemsackes-bramble on 8/4/17.
 */

class Period {
    String timestamp;
    String validTime;
    String dateTimeISO;
    String maxTempC;
    String maxTempF;
    String minTempC;
    String minTempF;
    String avgTempC;
    String avgTempF;

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

    public String getAvgTempC() {
        return avgTempC;
    }

    public void setAvgTempC(String avgTempC) {
        this.avgTempC = avgTempC;
    }

    public String getAvgTempF() {
        return avgTempF;
    }

    public void setAvgTempF(String avgTempF) {
        this.avgTempF = avgTempF;
    }
}
