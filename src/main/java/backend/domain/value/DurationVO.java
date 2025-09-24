package backend.domain.value;

/** Duration expressed in simulation ticks (>= 0). */
public record DurationVO(long ticks) {
    public DurationVO {
        if (ticks < 0) throw new IllegalArgumentException("ticks >= 0");
    }
}
