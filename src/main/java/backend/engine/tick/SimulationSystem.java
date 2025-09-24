package backend.engine.tick;

/** System that runs each tick. */
public interface SimulationSystem {
    void update(TickContext ctx);
}
