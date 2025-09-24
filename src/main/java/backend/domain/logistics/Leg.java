package backend.domain.logistics;

import backend.domain.network.TransportMode;

/** Single leg within a route. */
public record Leg(String edgeId, String fromNodeId, String toNodeId, TransportMode mode, long etaTicks) {
    public Leg {
        if (etaTicks <= 0) throw new IllegalArgumentException("etaTicks > 0");
    }
}
