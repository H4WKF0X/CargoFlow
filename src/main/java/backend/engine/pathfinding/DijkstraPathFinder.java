package backend.engine.pathfinding;

import backend.domain.logistics.Route;
import backend.domain.network.TransportMode;
import java.util.Set;

public final class DijkstraPathFinder implements PathFinder {
    @Override public Route find(String fromNodeId, String toNodeId, Set<TransportMode> allowedModes) {
        throw new UnsupportedOperationException("TODO");
    }
}
