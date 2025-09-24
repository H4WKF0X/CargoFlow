package backend.engine.metrics;

import backend.domain.common.DomainEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Collects domain events for logging/KPIs. */
public final class EventLog {
    private final List<DomainEvent> events = new ArrayList<>();
    public void append(DomainEvent e) { events.add(e); }
    public List<DomainEvent> all() { return Collections.unmodifiableList(events); }
}
