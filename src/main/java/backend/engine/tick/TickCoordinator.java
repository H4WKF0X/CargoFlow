package backend.engine.tick;

import backend.domain.repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Coordinates Sense -> Decide/Compute -> Commit phases. */
public final class TickCoordinator {
    private World currentWorld;
    private final List<SimulationSystem> systems = new ArrayList<>();
    private final TickClock clock;
    private final Random rng;

    private final CompanyRepository companyRepo;
    private final SiteRepository siteRepo;
    private final OrderRepository orderRepo;
    private final AccountRepository accountRepo;
    private final MarketRepository marketRepo;
    private final NetworkRepository networkRepo;
    private final ShipmentRepository shipmentRepo;
    private final VehicleRepository vehicleRepo;

    public TickCoordinator(World bootstrapWorld, List<SimulationSystem> systems, TickClock clock, Random rng,
                           CompanyRepository companyRepo, SiteRepository siteRepo,
                           OrderRepository orderRepo, AccountRepository accountRepo,
                           MarketRepository marketRepo, NetworkRepository networkRepo,
                           ShipmentRepository shipmentRepo, VehicleRepository vehicleRepo) {
        this.currentWorld = bootstrapWorld;
        this.systems.addAll(systems);
        this.clock = clock;
        this.rng= rng;

        this.companyRepo = companyRepo;
        this.siteRepo = siteRepo;
        this.orderRepo = orderRepo;
        this.accountRepo = accountRepo;
        this.marketRepo = marketRepo;
        this.networkRepo = networkRepo;
        this.shipmentRepo = shipmentRepo;
        this.vehicleRepo = vehicleRepo;
    }

    void registerSystem(SimulationSystem sys) {
        if (sys == null) {
            throw new IllegalArgumentException("System cannot be null");
        }
        systems.add(sys);
    }
    
    public World currentWorldSnapshot() {
        return this.currentWorld;
    }

    public void step() {
        World world = currentWorldSnapshot();
        WorldMutable target = new WorldMutable(clock, companyRepo, siteRepo, orderRepo, accountRepo, marketRepo, networkRepo, shipmentRepo, vehicleRepo);

        TickContext ctx = new TickContext(world, target, clock, rng);
        for (SimulationSystem sys : systems) {
            sys.update(ctx); // darf nur queueCommand machen
        }

        List<DomainCommand> cmds = target.drainQueueCommands();
        for (DomainCommand cmd : cmds) {
            cmd.apply(target);
        }

        clock.advance();
        World next;
        this.currentWorld = world;
        // TODO: publish World(t), run systems (parallel), commit to World(t+1)
    }
}
