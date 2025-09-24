package backend.domain.logistics;

import backend.domain.common.Entity;
import backend.domain.value.Capacity;

/** Vehicle entity (owned by a site). */
public final class Vehicle extends Entity {
    private final VehicleKind kind;
    private final Capacity capacity;
    private String locationNodeId;
    private VehicleState state = VehicleState.IDLE;

    public Vehicle(String id, VehicleKind kind, Capacity capacity, String locationNodeId) {
        super(id);
        this.kind = kind; this.capacity = capacity; this.locationNodeId = locationNodeId;
    }

    public VehicleKind kind() { return kind; }
    public Capacity capacity() { return capacity; }
    public String locationNodeId() { return locationNodeId; }
    public VehicleState state() { return state; }

    // MVP transitions
    public void assignToNode(String nodeId) { this.locationNodeId = nodeId; }
    public void setState(VehicleState newState) { this.state = newState; }
}
