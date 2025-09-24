package backend.engine.tick;

import java.util.Random;

/** Context passed to systems per tick. */
public record TickContext(World world, WorldMutable target, TickClock clock, Random rng) { }
