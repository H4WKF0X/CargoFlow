package backend.domain.network;

import backend.domain.value.Distance;

/** Directed edge between nodes with mode, distance, base capacity/cost. */
public final class NetworkEdge {
    private final String id;
    private final String fromNodeId;
    private final String toNodeId;
    private final TransportMode mode;
    private final Distance distanceKm;
    private final long capacityPerTick; // MVP
    private final long baseCost;        // MVP: cost in tens (domain rule lifted to Money elsewhere)

    public NetworkEdge(String id, String fromNodeId, String toNodeId,
                       TransportMode mode, Distance distanceKm,
                       long capacityPerTick, long baseCost) {
        this.id = id; this.fromNodeId = fromNodeId; this.toNodeId = toNodeId;
        this.mode = mode; this.distanceKm = distanceKm;
        this.capacityPerTick = capacityPerTick; this.baseCost = baseCost;
    }

    public String id() { return id; }
    public String fromNodeId() { return fromNodeId; }
    public String toNodeId() { return toNodeId; }
    public TransportMode mode() { return mode; }
    public Distance distanceKm() { return distanceKm; }
    public long capacityPerTick() { return capacityPerTick; }
    public long baseCost() { return baseCost; }
}
