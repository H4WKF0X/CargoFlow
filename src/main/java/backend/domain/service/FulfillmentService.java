package backend.domain.service;

import backend.domain.logistics.Order;
import backend.domain.logistics.Shipment;

/** Orchestrates order -> shipment creation. */
public interface FulfillmentService {
    Shipment createShipmentForOrder(Order order, String preferredAlgo);
}
