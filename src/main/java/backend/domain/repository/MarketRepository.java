package backend.domain.repository;

import backend.domain.market.DemandNode;
import java.util.List;

public interface MarketRepository {
    List<DemandNode> all();
    void saveAll(List<DemandNode> nodes);
}
