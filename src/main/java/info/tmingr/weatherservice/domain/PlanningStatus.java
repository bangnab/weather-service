package info.tmingr.weatherservice.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlanningStatus {
    private final PlanningEntity planningEntity;
    private final WeatherForecast latestForecast;
    private final Map<WeatherCriteria, Boolean> criteriaFullfilled;

    public PlanningStatus(PlanningEntity planningEntity, WeatherForecast latestForecast) {
        this.planningEntity = planningEntity;
        this.latestForecast = latestForecast;
        this.criteriaFullfilled = checkStatus(planningEntity.getCriteria(), latestForecast);
    }

    private Map<WeatherCriteria, Boolean> checkStatus(Set<WeatherCriteria> criteria, WeatherForecast latestForecast) {
        Map<WeatherCriteria, Boolean> fulfilledCriteria = new HashMap<>();
        criteria.forEach(it -> fulfilledCriteria.put(it, check(it, latestForecast)));
        return fulfilledCriteria;
    }

    private boolean check(WeatherCriteria it, WeatherForecast latestForecast) {
        return true;
    }
}
