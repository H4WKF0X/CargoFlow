package backend.domain.repository;

import backend.domain.network.TransportGraph;

import java.util.Optional;

public interface NetworkRepository {
    Optional<TransportGraph> current(); // MVP: single graph
    void save(TransportGraph graph);
}
