package cargoai.policy;

import cargoai.agent.ActionPlan;
import cargoai.agent.Observation;

/** Strategy for mapping observation -> action plan. */
public interface AgentPolicy {
    ActionPlan decide(Observation observation);
}