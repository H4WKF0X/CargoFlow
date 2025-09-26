package backend.engine.tick;

import backend.domain.common.DomainEvent;
import backend.domain.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Mutable target during commit phase; builds next World.
 */
public final class WorldMutable {
    private final List<DomainEvent> events = new ArrayList<>();
    private final ConcurrentLinkedQueue<DomainCommand> commandQueue = new ConcurrentLinkedQueue<>();

    private final TickClock clock;

    private final CompanyRepository companyRepo;
    private final SiteRepository siteRepo;
    private final OrderRepository orderRepo;
    private final AccountRepository accountRepo;
    private final MarketRepository marketRepo;
    private final NetworkRepository networkRepo;
    private final ShipmentRepository shipmentRepo;
    private final VehicleRepository vehicleRepo;

    public WorldMutable(TickClock clock,
                        CompanyRepository companyRepo, SiteRepository siteRepo,
                        OrderRepository orderRepo, AccountRepository accountRepo,
                        MarketRepository marketRepo, NetworkRepository networkRepo,
                        ShipmentRepository shipmentRepo, VehicleRepository vehicleRepo) {
        this.clock = clock;
        this.companyRepo = companyRepo;
        this.siteRepo = siteRepo;
        this.orderRepo = orderRepo;
        this.accountRepo = accountRepo;
        this.marketRepo = marketRepo;
        this.networkRepo = networkRepo;
        this.shipmentRepo = shipmentRepo;
        this.vehicleRepo = vehicleRepo;
    }
    public World buildSnapshot() {
        return new World(clock.current(), null);
    }

    public void apply(DomainCommand cmd) {
        cmd.apply(this);
    }

    public void queueCommand(DomainCommand cmd) {
        if (cmd == null) throw new NullPointerException("CMD is null");
        commandQueue.add(cmd);
    }

    public List<DomainCommand> drainQueueCommands() {
        List<DomainCommand> cmds = new ArrayList<>();
        while (!commandQueue.isEmpty()) {
            cmds.add(commandQueue.poll());
        }

        return cmds;
    }

    public void emit(DomainEvent e) {
        events.add(e);
    }

    public List<DomainEvent> events() {
        return List.copyOf(events);
    }

    // TODO: builders/writers for repositories
}
