package backend.engine.pathfinding;

import backend.domain.network.NetworkEdge;

/** Linear cost function per edge/mode (MVP). */
@FunctionalInterface
public interface MultiModalCostFunction {
    long cost(NetworkEdge edge); // return in "tens" units as per domain money rule
}
