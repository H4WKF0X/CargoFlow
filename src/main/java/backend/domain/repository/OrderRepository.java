package backend.domain.repository;

import backend.domain.logistics.Order;
import java.util.List;

public interface OrderRepository extends Repository<Order> {
    List<Order> findOpenBySite(String siteId);
}
