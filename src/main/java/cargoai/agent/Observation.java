package cargoai.agent;

/** Normalized features for agent decision making. */
public record Observation(String siteId, double balanceNorm, double openOrdersNorm,
                          double avgEdgeCostNorm, double fleetUtilization) { }
