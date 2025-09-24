package iface.exporter;

import backend.engine.metrics.MetricsRegistry;
import backend.engine.metrics.EventLog;
import java.nio.file.Path;

/** Writes CSV exports for events/KPIs (MVP). */
public final class CsvExporter {
    public void writeEvents(EventLog log, Path file) { /* TODO */ }
    public void writeKPIs(MetricsRegistry mr, Path file) { /* TODO */ }
}
