package info.tmingr.weatherservice.domain;

import java.time.Instant;

public class TimeSpan {

    private final Instant start;
    private final Instant end;

    public TimeSpan(Instant start, Instant end) {
        this.start = start;
        this.end = end;
    }

    public boolean inclues(Instant between) {
        return between.isAfter(start) && between.isBefore(end);
    }

    public Instant getStart() {
        return start;
    }

    public Instant getEnd() {
        return end;
    }
}
