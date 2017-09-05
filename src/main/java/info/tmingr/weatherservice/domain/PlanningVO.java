package info.tmingr.weatherservice.domain;

import java.util.Set;

public class PlanningVO {
    private final UserId userId;
    private final LocationVO locationVO;
    private final TimeSpan timeSpan;
    private Set<WeatherCriteria> weatherCriteriaSet;

    public PlanningVO(UserId userId, LocationVO locationVO, TimeSpan timeSpan, Set<WeatherCriteria> weatherCriteriaSet) {
        this.userId = userId;
        this.locationVO = locationVO;
        this.timeSpan = timeSpan;
        this.weatherCriteriaSet = weatherCriteriaSet;
    }

    public LocationVO getLocation() {
        return locationVO;
    }

    public Set<WeatherCriteria> getCriteria() {
        return weatherCriteriaSet;
    }
}
