package iface.api;

import backend.engine.tick.World;

/** Port for CLI/external tools. */
public interface BackendPort {
    World worldSnapshot();
    // listOpenOrders(), createShipment(), allocateVehicle() etc. to be added
}
