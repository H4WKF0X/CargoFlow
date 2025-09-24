package backend.domain.value;

/** Speed in km/h (>= 0). */
public record Speed(double kmPerHour) {
    public Speed {
        if (kmPerHour < 0) throw new IllegalArgumentException("km/h >= 0");
    }
}
