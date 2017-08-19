package info.tmingr.weatherservice.rest.wuapi;

public interface WeatherProvider {

    WeatherForecast getCurrentForecastFor(LocationVO locationVO);
}
