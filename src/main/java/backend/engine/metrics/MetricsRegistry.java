package backend.engine.metrics;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** Simple counters/gauges registry. */
public final class MetricsRegistry {
    private final Map<String, Long> counters = new ConcurrentHashMap<>();
    public void inc(String name, long by) { counters.merge(name, by, Long::sum); }
    public Map<String, Long> snapshot() { return Map.copyOf(counters); }
}
