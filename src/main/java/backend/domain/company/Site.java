package backend.domain.company;

import backend.domain.common.AggregateRoot;
import backend.domain.value.Capacity;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/** Operational site; owns fleet/toolset/account (by IDs/refs). */
public final class Site extends AggregateRoot {
    private final String companyId;
    private final String homeNodeId;
    private final String accountId;
    private final Set<String> vehicleIds = new LinkedHashSet<>();

    public Site(String id, String companyId, String homeNodeId, String accountId) {
        super(id);
        this.companyId = companyId;
        this.homeNodeId = homeNodeId;
        this.accountId = accountId;
    }

    public String companyId() { return companyId; }
    public String homeNodeId() { return homeNodeId; }
    public String accountId() { return accountId; }
    public Set<String> vehicleIds() { return Collections.unmodifiableSet(vehicleIds); }

    // MVP: fleet management
    public boolean addVehicle(String vehicleId) { return vehicleIds.add(vehicleId); }
    public boolean removeVehicle(String vehicleId) { return vehicleIds.remove(vehicleId); }
}
