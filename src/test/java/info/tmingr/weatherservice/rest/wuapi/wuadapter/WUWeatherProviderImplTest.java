package info.tmingr.weatherservice.rest.wuapi.wuadapter;

import info.tmingr.weatherservice.domain.WeatherForecast;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WUWeatherProviderImplTest {

    WUWeatherProviderImpl wuWeatherProvider = new WUWeatherProviderImpl();

    @Test
    public void getCurrentForecastFor() throws IOException {

        WeatherForecast wuWeatherForecast = wuWeatherProvider.getWuWeatherForecast(new File("Alingsas.json"));
        assertThat(wuWeatherForecast.getForecast().size(), is(240));
    }



}