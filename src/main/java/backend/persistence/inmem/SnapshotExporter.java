package backend.persistence.inmem;

import java.nio.file.Path;

/** Writes snapshots / events / KPIs to files (MVP: CSV/JSON later). */
public final class SnapshotExporter {
    private final Path outDir;
    public SnapshotExporter(Path outDir) { this.outDir = outDir; }
    // TODO writeEvents(), writeKPIs(), writeState()
}
