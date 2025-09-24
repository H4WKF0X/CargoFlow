package backend.domain.common;

public interface DomainEvent {
    String eventId();         // UUID string
    String type();            // "ShipmentPlanned"
    String aggregateType();   // "Shipment"
    String aggregateId();     // shipmentId
    long occurredTick();      // simulation tick
    java.util.Map<String, Object> data(); // lightweight payload for logging
}
