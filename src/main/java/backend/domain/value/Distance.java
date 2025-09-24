package backend.domain.value;

/** Distance in kilometers (>= 0). */
public record Distance(long km) {
    public Distance {
        if (km < 0) throw new IllegalArgumentException("km >= 0");
    }
    public double toMeters() { return km * 1_000.0; }
}
