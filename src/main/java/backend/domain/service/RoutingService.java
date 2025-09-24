package backend.domain.service;

import backend.domain.logistics.Route;
import backend.domain.network.TransportMode;

import java.util.Set;

/** Plans a route on the transport graph (strategy injected elsewhere). */
public interface RoutingService {
    Route planRoute(String fromNodeId, String toNodeId, Set<TransportMode> allowedModes);
}
