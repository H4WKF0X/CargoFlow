package backend.domain.repository;

import backend.domain.logistics.Vehicle;
import java.util.List;

public interface VehicleRepository extends Repository<Vehicle> {
    List<Vehicle> findBySite(String siteId);
}
