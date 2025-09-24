package cargoai.agent;

/** Sealed action hierarchy (extend with concrete actions later). */
public sealed interface Action permits PlanShipment, AcquireVehicle, ChoosePathfinder { }

record PlanShipment(String orderId, String preferredMode, String pathfinderName) implements Action { }
record AcquireVehicle(String kind, long capacityUnits) implements Action { }
record ChoosePathfinder(String name) implements Action { }
