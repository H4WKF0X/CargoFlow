package backend.engine.pathfinding;

import backend.domain.logistics.Route;
import backend.domain.network.TransportMode;
import java.util.Set;

/** Path finding strategy iface. */
public interface PathFinder {
    Route find(String fromNodeId, String toNodeId, Set<TransportMode> allowedModes);
}
