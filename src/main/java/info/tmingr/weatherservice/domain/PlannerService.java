package info.tmingr.weatherservice.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PlannerService {
    private PlanningRepository planningRepository;
    private WeatherProvider weatherProvider;

    PlanningEntity createPlanning(UserId userId, LocationVO locationVO, TimeSpan timeSpan,
            Set<WeatherCriteria> weatherCriteriaList) {
        PlanningVO planningVO = new PlanningVO(userId, locationVO, timeSpan, weatherCriteriaList);
        PlanningEntity planningEntity = planningRepository.create(planningVO);
        return planningEntity;
    }

    List<PlanningEntity> listPlannings(TimeSpan timeSpan) {
        if (timeSpan == null) {
            return new ArrayList<>();
        }
        return planningRepository.findPlanningsBetween(timeSpan.getStart(), timeSpan.getEnd());
    }

    PlanningStatus getStatus(PlanningId planningId) {
        PlanningEntity planningEntity = planningRepository.findById(planningId);
        WeatherForecast latestForecast = weatherProvider.getCurrentForecastFor(planningEntity.getLocation());
        return new PlanningStatus(planningEntity, latestForecast);
    }
}
