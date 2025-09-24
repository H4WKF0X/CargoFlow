package backend.domain.network;

import java.util.*;

/** Multimodal transport graph with adjacency. */
public final class TransportGraph {
    private final Map<String, NetworkNode> nodes;
    private final Map<String, List<NetworkEdge>> adj; // fromNodeId -> outgoing edges

    public TransportGraph(Map<String, NetworkNode> nodes, Map<String, List<NetworkEdge>> adj) {
        this.nodes = Map.copyOf(nodes);
        Map<String, List<NetworkEdge>> copy = new HashMap<>();
        adj.forEach((k,v) -> copy.put(k, List.copyOf(v)));
        this.adj = Collections.unmodifiableMap(copy);
    }

    public Optional<NetworkNode> node(String id) { return Optional.ofNullable(nodes.get(id)); }
    public List<NetworkEdge> outgoing(String nodeId) { return adj.getOrDefault(nodeId, List.of()); }
    public Collection<NetworkNode> nodes() { return nodes.values(); }
}
