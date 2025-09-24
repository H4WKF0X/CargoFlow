package backend.domain.repository;

import backend.domain.logistics.Shipment;
import java.util.List;

public interface ShipmentRepository extends Repository<Shipment> {
    List<Shipment> findByStatus(backend.domain.logistics.ShipmentStatus status);
}
