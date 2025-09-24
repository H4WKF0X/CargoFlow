package backend.domain.logistics;

import backend.domain.common.AggregateRoot;

/** Customer order aggregate root. */
public final class Order extends AggregateRoot {
    public enum Status { OPEN, ALLOCATED, FULFILLED, EXPIRED }
    private Status status = Status.OPEN;

    private final String originSiteId;
    private final String destinationNodeId;
    private final String sku;
    private final long quantityUnits;
    private final long dueTick;

    public Order(String id, String originSiteId, String destinationNodeId,
                 String sku, long quantityUnits, long dueTick) {
        super(id);
        this.originSiteId = originSiteId; this.destinationNodeId = destinationNodeId;
        this.sku = sku; this.quantityUnits = quantityUnits; this.dueTick = dueTick;
    }

    public Status status() { return status; }
    public void markAllocated() { if (status != Status.OPEN) throw new IllegalStateException(); status = Status.ALLOCATED; }
    public void markFulfilled() { if (status != Status.ALLOCATED) throw new IllegalStateException(); status = Status.FULFILLED; }

    public String originSiteId() { return originSiteId; }
    public String destinationNodeId() { return destinationNodeId; }
    public String sku() { return sku; }
    public long quantityUnits() { return quantityUnits; }
    public long dueTick() { return dueTick; }
}
