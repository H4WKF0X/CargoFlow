package backend.engine.tick;

import backend.domain.common.DomainEvent;
import java.util.ArrayList;
import java.util.List;

/** Mutable target during commit phase; builds next World. */
public final class WorldMutable {
    private final List<DomainEvent> events = new ArrayList<>();
    public void apply(DomainCommand cmd) { cmd.apply(this); }
    public void emit(DomainEvent e) { events.add(e); }
    public List<DomainEvent> events() { return List.copyOf(events); }
    // TODO: builders/writers for repositories
}
