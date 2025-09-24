package backend.domain.logistics;

import backend.domain.common.AggregateRoot;

/** Shipment aggregate root with route & progress. */
public final class Shipment extends AggregateRoot {
    private final String orderId;
    private final Route route;
    private int currentLegIndex = 0;
    private ShipmentStatus status = ShipmentStatus.PLANNED;

    public Shipment(String id, String orderId, Route route) {
        super(id);
        this.orderId = orderId; this.route = route;
    }

    public String orderId() { return orderId; }
    public Route route() { return route; }
    public int currentLegIndex() { return currentLegIndex; }
    public ShipmentStatus status() { return status; }

    // MVP: simple state transitions
    public void start() { if (status != ShipmentStatus.PLANNED) throw new IllegalStateException(); status = ShipmentStatus.IN_TRANSIT; }
    public void arriveLeg() { currentLegIndex++; if (currentLegIndex >= route.legs().size()) status = ShipmentStatus.DELIVERED; }
}
