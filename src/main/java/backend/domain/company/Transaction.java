package backend.domain.company;

import backend.domain.value.Money;

/** Immutable account transaction (single-entry). */
public record Transaction(String reason, Money amount, long tick) {
    public Transaction {
        if (amount == null) throw new IllegalArgumentException("amount != null");
        if (reason == null || reason.isBlank()) reason = "n/a";
        if (tick < 0) throw new IllegalArgumentException("tick >= 0");
    }
}
