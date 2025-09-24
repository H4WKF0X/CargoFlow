package backend.engine.tick;

import java.util.Map;

/** Immutable world snapshot at beginning of a tick (MVP simplified). */
public final class World {
    private final long tick;
    private final Map<Class<?>, Object> views; // read-only views/DTOs

    public World(long tick, Map<Class<?>, Object> views) {
        this.tick = tick;
        this.views = Map.copyOf(views);
    }
    public long tick() { return tick; }
    @SuppressWarnings("unchecked")
    public <T> T view(Class<T> type) { return (T) views.get(type); }
}
