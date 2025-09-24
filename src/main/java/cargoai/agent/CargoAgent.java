package cargoai.agent;

import cargoai.policy.AgentPolicy;
import java.util.Objects;

/** AI agent per site: Observation -> ActionPlan using a policy. */
public final class CargoAgent {
    private final String siteId;
    private final AgentPolicy policy;

    public CargoAgent(String siteId, AgentPolicy policy) {
        this.siteId = Objects.requireNonNull(siteId);
        this.policy = Objects.requireNonNull(policy);
    }

    public String siteId() { return siteId; }
    public AgentPolicy policy() { return policy; }
}
