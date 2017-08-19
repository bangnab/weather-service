package info.tmingr.weatherservice.rest.wuapi.wuadapter;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import info.tmingr.weatherservice.rest.wuapi.HourForecast;
import info.tmingr.weatherservice.rest.wuapi.LocationVO;
import info.tmingr.weatherservice.rest.wuapi.WeatherForecast;
import info.tmingr.weatherservice.rest.wuapi.WeatherProvider;

import javax.enterprise.context.Dependent;
import info.tmingr.weatherservice.rest.wuapi.LocationVO;
import info.tmingr.weatherservice.rest.wuapi.HourForecast;
import info.tmingr.weatherservice.rest.wuapi.WeatherForecast;
import info.tmingr.weatherservice.rest.wuapi.WeatherProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class WUWeatherProviderImpl implements WeatherProvider {

    @Override
    public WeatherForecast getCurrentForecastFor(LocationVO locationVO) {
        try {
            return getWuWeatherForecast(new File("Alingsas.json"));
        } catch (IOException e) {
            e.printStackTrace();
            return new WeatherForecast();
        }
    }

    WeatherForecast getWuWeatherForecast(File file) throws IOException {
        JsonFactory f = new JsonFactory();
        JsonParser jp = f.createParser(file);
        WeatherForecast wuWeatherForecast = new WeatherForecast();
        JsonToken current = jp.nextToken(); // will return JsonToken.START_OBJECT (verify?)
        ForecastJsonState state = ForecastJsonState.ROOT;
        String currentFieldName;
        HourForecast currentHourForecast = new HourForecast();
        List<HourForecast> hourForecastList = new ArrayList<>();
        int currentTemp;
        while (current != null) {
            switch (current) {
            case FIELD_NAME:
                currentFieldName = jp.getCurrentName();
                switch (currentFieldName) {
                case "hourly_forecast":
                    hourForecastList = new ArrayList<>();
                    state = ForecastJsonState.HOURLY_FORECAST;
                    break;
                case "temp":
                    state = ForecastJsonState.TEMP;
                    break;
                case "metric":
                    if (state == ForecastJsonState.TEMP) {
                        jp.nextToken();
                        currentTemp = Integer.parseInt(jp.getText());
                        currentHourForecast.setMinTemp(currentTemp);
                    }
                    break;
                case "FCTTIME":
                    state = ForecastJsonState.FCTTIME;
                    break;
                case "epoch":
                    jp.nextToken();
                    currentHourForecast = new HourForecast();
                    currentHourForecast.setInstant(Long.parseLong(jp.getText()));
                    break;
                }
                break;
            case END_OBJECT:
                switch (state) {
                case TEMP:
                    state = ForecastJsonState.HOURLY_FORECAST;
                    hourForecastList.add(currentHourForecast);
                    break;
                case HOURLY_FORECAST:
                    state = ForecastJsonState.ROOT;
                    break;
                case FCTTIME:
                    state = ForecastJsonState.HOURLY_FORECAST;
                    break;
                }
            }
            current = jp.nextToken();
        }
        wuWeatherForecast.setForecast(hourForecastList);
        jp.close();
        return wuWeatherForecast;
    }
}
