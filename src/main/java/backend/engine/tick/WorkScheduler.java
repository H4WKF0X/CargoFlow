package backend.engine.tick;

import java.util.concurrent.ExecutorService;

/** Holds thread pools (AI, pathfinding, systems). */
public final class WorkScheduler {
    private final ExecutorService systemPool;
    public WorkScheduler(ExecutorService systemPool) { this.systemPool = systemPool; }
    public ExecutorService systemPool() { return systemPool; }
}
