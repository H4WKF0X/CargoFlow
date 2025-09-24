package backend.domain.value;

/** Transport capacity (tons, volume m3, units). Use what you need. */
public record Capacity(double tons, double volumeM3, long units) {
    public Capacity {
        if (tons < 0 || volumeM3 < 0 || units < 0)
            throw new IllegalArgumentException("capacity values must be >= 0");
    }
}
