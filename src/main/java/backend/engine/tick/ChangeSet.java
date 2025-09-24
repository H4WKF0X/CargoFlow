package backend.engine.tick;

/** Optional batch of commands. */
public record ChangeSet(java.util.List<DomainCommand> commands) { }
