package info.tmingr.weatherservice.rest.wuapi;

import java.time.Instant;

public class HourForecast {
    private int minTemp;
    private Instant instant;

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public void setInstant(long epoch) {
        this.instant = Instant.ofEpochSecond(epoch);
    }
}
