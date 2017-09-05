package info.tmingr.weatherservice.domain;

import java.util.Set;

public class PlanningEntity {
    private final PlanningId planningId;
    private final PlanningVO planningVO;

    public PlanningEntity(PlanningId planningId, PlanningVO planningVO) {
        this.planningId = planningId;
        this.planningVO = planningVO;
    }

    public LocationVO getLocation() {
        return planningVO.getLocation();
    }

    public Set<WeatherCriteria> getCriteria() {
        return planningVO.getCriteria();
    }
}
