package backend.domain.value;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Currency;
import java.util.Objects;

/**
 * Grobes Geld-Value-Object:
 * - Alle Beträge ausschließlich in 10er-Schritten erlaubt.
 * - Verstöße führen zu IllegalArgumentException.
 * - Immutable, value-based equals/hashCode (record).
 */
public record Money(BigDecimal amount, Currency currency) implements Comparable<Money> {
    private static final MathContext MC = MathContext.DECIMAL64;

    public Money {
        Objects.requireNonNull(amount, "amount");
        Objects.requireNonNull(currency, "currency");

        if (!isMultipleOfTen(amount)) {
            throw new IllegalArgumentException("Amount must be a multiple of 10: " + amount);
        }
    }

    public static Money ofMajor(long major, Currency ccy) {
        return new Money(BigDecimal.valueOf(major), ccy);
    }

    public static Money of(BigDecimal amount, Currency ccy) {
        return new Money(amount, ccy);
    }

    public Money plus(Money other) {
        assertSameCurrency(other);
        return new Money(this.amount.add(other.amount, MC), this.currency);
    }

    public Money minus(Money other) {
        assertSameCurrency(other);
        return new Money(this.amount.subtract(other.amount, MC), this.currency);
    }

    public Money times(BigDecimal factor) {
        BigDecimal result = this.amount.multiply(factor, MC);
        if (!isMultipleOfTen(result)) {
            throw new IllegalArgumentException("Result not multiple of 10: " + result);
        }
        return new Money(result, currency);
    }

    public Money percent(int pct) {
        return times(BigDecimal.valueOf(pct).movePointLeft(2));
    }

    public boolean isZero()     { return amount.signum() == 0; }
    public boolean isPositive() { return amount.signum() > 0; }
    public boolean isNegative() { return amount.signum() < 0; }

    @Override
    public int compareTo(Money o) {
        assertSameCurrency(o);
        return this.amount.compareTo(o.amount);
    }

    private void assertSameCurrency(Money o) {
        if (!this.currency.equals(o.currency)) {
            throw new IllegalArgumentException("Currency mismatch: " + this.currency + " vs " + o.currency);
        }
    }

    private static boolean isMultipleOfTen(BigDecimal value) {
        return value.remainder(BigDecimal.TEN).compareTo(BigDecimal.ZERO) == 0;
    }

    @Override
    public String toString() {
        return currency.getCurrencyCode() + " " + amount.toPlainString();
    }
}
