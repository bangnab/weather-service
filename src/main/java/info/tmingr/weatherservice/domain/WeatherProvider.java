package info.tmingr.weatherservice.domain;

public interface WeatherProvider {

    WeatherForecast getCurrentForecastFor(LocationVO locationVO);
}
