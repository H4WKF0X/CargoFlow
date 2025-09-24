package backend.domain.value;

/** Geographic coordinates. */
public record Coordinates(double latitude, double longitude) {
    public Coordinates {
        if (latitude < -90 || latitude > 90) throw new IllegalArgumentException("lat [-90,90]");
        if (longitude < -180 || longitude > 180) throw new IllegalArgumentException("lon [-180,180]");
    }
}
