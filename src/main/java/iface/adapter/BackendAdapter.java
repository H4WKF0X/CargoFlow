package iface.adapter;

import iface.api.BackendPort;
import backend.engine.tick.World;

/** Backend adapter for CLI/tools. */
public final class BackendAdapter implements BackendPort {
    @Override public World worldSnapshot() { throw new UnsupportedOperationException("TODO"); }
}
