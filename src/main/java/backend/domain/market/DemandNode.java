package backend.domain.market;

import java.util.Random;

/** Demand at a network node for a (simplified) SKU. */
public final class DemandNode {
    private final String nodeId;
    private final long seed;

    public DemandNode(String nodeId, long seed) {
        this.nodeId = nodeId;
        this.seed = seed;
    }

    public String nodeId() { return nodeId; }

    /** MVP: deterministic pseudo-random demand by tick. */
    public long demandAt(long tick) {
        Random rng = new Random(seed ^ tick);
        return 50 + rng.nextInt(100); // 50..149, einfache Verteilung
    }
}
