package backend.domain.network;

import backend.domain.value.Coordinates;

/** Node in transport network (port, airport, depot, warehouse). */
public final class NetworkNode {
    private final String id;
    private final String type; // MVP: stringly-typed node type
    private final Coordinates coordinates;

    public NetworkNode(String id, String type, Coordinates coordinates) {
        this.id = id; this.type = type; this.coordinates = coordinates;
    }

    public String id() { return id; }
    public String type() { return type; }
    public Coordinates coordinates() { return coordinates; }
}
