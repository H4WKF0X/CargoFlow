package backend.domain.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AggregateRoot extends Entity {
    private final List<DomainEvent> pendingEvents = new ArrayList<>();

    protected AggregateRoot(String id) {
        super(id);
    }

    protected final void recordEvent(DomainEvent event) {
        pendingEvents.add(Objects.requireNonNull(event));
    }

    public final List<DomainEvent> pullDomainEvents() {
        List<DomainEvent> copy = List.copyOf(pendingEvents);
        pendingEvents.clear();
        return copy;
    }
}
