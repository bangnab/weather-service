package info.tmingr.weatherservice.domain;

import java.time.Instant;

public class HourForecast {
    private int temp;
    private Instant instant;

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void setInstant(long epoch) {
        this.instant = Instant.ofEpochSecond(epoch);
    }

    public Instant getInstant() {
        return instant;
    }

    public String getName() {return "test";}
}
