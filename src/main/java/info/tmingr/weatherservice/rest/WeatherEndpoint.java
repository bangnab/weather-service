package info.tmingr.weatherservice.rest;

import info.tmingr.weatherservice.domain.WeatherForecast;
import info.tmingr.weatherservice.domain.WeatherProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

@ApplicationScoped
@ApplicationPath("/")
@Path("/weather")
public class WeatherEndpoint extends Application {

	@Inject private WeatherProvider weatherProvider;

	@GET
	@Produces("application/json")
	public WeatherForecast doGet() {
		return weatherProvider.getCurrentForecastFor(null);
	}


    @GET
    @Produces("text/plain")
    public Response doGet_hello() {
        return Response.ok("Hello from WildFly Swarm!").build();
    }
}
