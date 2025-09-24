package backend.engine.tick;

/** Command that mutates WorldMutable during commit. */
public interface DomainCommand {
    void apply(WorldMutable m);
}
