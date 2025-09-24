package backend.persistence.inmem;

import backend.domain.repository.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/** Generic in-memory repository for aggregates. */
public class InMemoryRepository<T> implements Repository<T> {
    protected final Map<String, T> store = new ConcurrentHashMap<>();
    protected String idOf(T agg) { throw new UnsupportedOperationException("extract id"); } // override or adapt

    @Override public Optional<T> findById(String id) { return Optional.ofNullable(store.get(id)); }
    @Override public List<T> findAll() { return List.copyOf(store.values()); }
    @Override public void save(T aggregate) { store.put(idOf(aggregate), aggregate); }
}
