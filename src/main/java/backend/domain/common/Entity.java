package backend.domain.common;

import java.util.UUID;

public abstract class Entity {
    private final String id;

    protected Entity(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id must not be null or blank");
        }
        this.id = id;
    }

    protected static String newId() {
        return UUID.randomUUID().toString();
    }

    public final String getId() {
        return id;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity other = (Entity) o;
        return id.equals(other.id);
    }

    @Override
    public final int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id=" + id + "]";
    }
}
