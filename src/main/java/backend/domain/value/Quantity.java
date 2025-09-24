package backend.domain.value;

/** Quantity of units (>= 0). */
public record Quantity(long units) {
    public Quantity {
        if (units < 0) throw new IllegalArgumentException("units >= 0");
    }
}
