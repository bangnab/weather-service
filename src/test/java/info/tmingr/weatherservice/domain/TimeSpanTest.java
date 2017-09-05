package info.tmingr.weatherservice.domain;

import org.junit.Test;

import java.time.Instant;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TimeSpanTest {

    private final Instant start = Instant.ofEpochMilli(1_000_000L);
    private final Instant end = Instant.ofEpochMilli(1_000_000L + 200);

    @Test
    public void includes_betweenStartAndEnd_shouldReturnTrue() {
        Instant between = Instant.ofEpochMilli(1_000_000L + 100);

        TimeSpan timeSpan = new TimeSpan(start, end);

        assertThat(timeSpan.inclues(between), is(true));
    }

    @Test
    public void includes_beforeStart_shouldReturnFalse() {
        Instant before = Instant.ofEpochMilli(1_000_000L - 100);

        TimeSpan timeSpan = new TimeSpan(start, end);

        assertThat(timeSpan.inclues(before), is(false));
    }

    @Test
    public void includes_afterEnd_shouldReturnFalse() {
        Instant after = Instant.ofEpochMilli(1_000_000L + 300);

        TimeSpan timeSpan = new TimeSpan(start, end);

        assertThat(timeSpan.inclues(after), is(false));
    }


}
