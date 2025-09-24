package backend.engine.tick;

/** Simulation clock (tick counter). */
public final class TickClock {
    private long current = 0L;
    public long current() { return current; }
    public void advance() { current++; }
}
