package cargoai.tools;

import java.util.Map;

/** Tool catalog with prices/configuration per tool name. */
public final class ToolCatalog {
    private final Map<String, Long> toolPriceInTens;
    public ToolCatalog(Map<String, Long> toolPriceInTens) { this.toolPriceInTens = Map.copyOf(toolPriceInTens); }
    public Long priceOf(String toolName) { return toolPriceInTens.get(toolName); }
}
