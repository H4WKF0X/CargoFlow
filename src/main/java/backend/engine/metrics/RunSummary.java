package backend.engine.metrics;

/** Aggregate run summary. */
public record RunSummary(long ticks, int shipmentsDelivered, int bankruptcies) { }
