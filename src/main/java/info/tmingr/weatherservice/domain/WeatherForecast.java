package info.tmingr.weatherservice.domain;

import java.util.List;

public class WeatherForecast {
    private List<HourForecast> forecast;

    public List<HourForecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<HourForecast> forecast) {
        this.forecast = forecast;
    }
}
