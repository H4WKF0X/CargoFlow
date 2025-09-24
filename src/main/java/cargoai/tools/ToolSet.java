package cargoai.tools;

import java.util.Set;

/** Tool availability for a site (MVP). */
public final class ToolSet {
    private final Set<String> available;
    public ToolSet(Set<String> available) { this.available = Set.copyOf(available); }
    public boolean has(String toolName) { return available.contains(toolName); }
}
