package backend.domain.repository;

import java.util.*;

public interface Repository<T> {
    Optional<T> findById(String id);
    List<T> findAll();
    void save(T aggregate);
}
