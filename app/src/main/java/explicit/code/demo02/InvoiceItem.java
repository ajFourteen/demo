package explicit.code.demo02;

public class InvoiceItem {

    private Amount amount;
    private String description;
    private double vatRate;

    public InvoiceItem(Amount amount, String description, double vatRate) {
        this.amount = amount;
        this.description = description;
        this.vatRate = vatRate;
    }

    public Amount amount() {
        return this.amount;
    }

    public String description() {
        return this.description;
    }

    public double vatRate() {
        return this.vatRate;
    }

    public double vat() {
        return (double) this.amount().value() * (double) this.vatRate() / 100.0;
    }
    
    @Override
    public String toString() {
        return "%s: $ %s; %s% VAT".formatted(this.description, this.amount, this.vatRate);
    }
}
