package backend.engine.tick;

import java.util.List;

/** Coordinates Sense -> Decide/Compute -> Commit phases. */
public final class TickCoordinator {
    private final List<SimulationSystem> systems;
    private final TickClock clock;

    public TickCoordinator(List<SimulationSystem> systems, TickClock clock) {
        this.systems = List.copyOf(systems);
        this.clock = clock;
    }

    public void step() {
        // TODO: publish World(t), run systems (parallel), commit to World(t+1)
    }
}
