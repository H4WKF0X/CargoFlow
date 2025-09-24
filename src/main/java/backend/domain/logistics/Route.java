package backend.domain.logistics;

import java.util.List;

/** Immutable route (ordered legs). */
public record Route(List<Leg> legs) {
    public Route {
        if (legs == null || legs.isEmpty()) throw new IllegalArgumentException("legs must not be empty");
        legs = List.copyOf(legs);
    }
}
