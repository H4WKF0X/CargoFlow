package backend.domain.company;

import backend.domain.common.Entity;
import backend.domain.value.Money;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Simple ledger: balance and transactions. */
public final class Account extends Entity {
    private Money balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(String id, Money openingBalance) {
        super(id);
        this.balance = openingBalance;
    }

    public Money balance() { return balance; }
    public List<Transaction> transactions() { return Collections.unmodifiableList(transactions); }

    // MVP: credit/debit (no double-entry accounting)
    public void credit(Money amount, String reason, long tick) {
        if (amount.isNegative()) throw new IllegalArgumentException("amount must be >= 0");
        transactions.add(new Transaction(reason, amount, tick));
        balance = balance.plus(amount);
    }

    public void debit(Money amount, String reason, long tick) {
        if (amount.isNegative()) throw new IllegalArgumentException("amount must be >= 0");
        transactions.add(new Transaction(reason, amount.times(new java.math.BigDecimal("-1")), tick));
        balance = balance.minus(amount);
    }
}
