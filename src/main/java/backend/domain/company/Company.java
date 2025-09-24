package backend.domain.company;

import backend.domain.common.AggregateRoot;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/** Company aggregate root (owns sites). */
public final class Company extends AggregateRoot {
    private final String name;
    private final Set<String> siteIds = new LinkedHashSet<>(); // referenzen auf Sites

    public Company(String id, String name) {
        super(id);
        this.name = name;
    }

    public String name() { return name; }
    public Set<String> siteIds() { return Collections.unmodifiableSet(siteIds); }

    // MVP: register/list sites
    public boolean registerSite(String siteId) { return siteIds.add(siteId); }
    public boolean hasSite(String siteId) { return siteIds.contains(siteId); }
}
