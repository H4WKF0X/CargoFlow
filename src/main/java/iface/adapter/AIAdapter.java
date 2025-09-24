package iface.adapter;

import iface.api.AIPort;
import cargoai.agent.ActionPlan;
import cargoai.agent.Observation;

/** Anti-Corruption Layer for AI interactions. */
public final class AIAdapter implements AIPort {
    @Override public Observation getObservation(String siteId) { throw new UnsupportedOperationException("TODO"); }
    @Override public void submitActions(String siteId, ActionPlan plan) { /* TODO */ }
}
