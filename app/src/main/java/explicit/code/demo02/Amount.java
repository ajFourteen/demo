package explicit.code.demo02;

import java.text.DecimalFormat;

public class Amount {

    public static final Amount ZERO = new Amount(0);

    private final int amount;

    public Amount(int amount) {
        this.amount = amount;
    }

    public int value() {
        return this.amount;
    }

    public Amount add(Amount amount) {
        return new Amount(this.value() + amount.value());
    }

    @Override
    public String toString() {
        return new DecimalFormat("#0.00").format((double) this.amount / 100);
    }
}
