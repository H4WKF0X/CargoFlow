package iface.api;

import cargoai.agent.ActionPlan;
import cargoai.agent.Observation;

/** Port for AI <-> backend. */
public interface AIPort {
    Observation getObservation(String siteId);
    void submitActions(String siteId, ActionPlan plan);
}
