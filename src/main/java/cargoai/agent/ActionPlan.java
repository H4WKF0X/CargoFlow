package cargoai.agent;

import java.util.List;

/** Plan of actions produced by the agent. */
public record ActionPlan(List<Action> actions) { }
