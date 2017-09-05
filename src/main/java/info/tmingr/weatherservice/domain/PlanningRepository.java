package info.tmingr.weatherservice.domain;

import java.time.Instant;
import java.util.List;

public interface PlanningRepository {
    PlanningEntity create(PlanningVO planningVO);

    List<PlanningEntity> findPlanningsBetween(Instant start, Instant end);

    List<PlanningEntity> findAll();;

    PlanningEntity findById(PlanningId planningId);
}
