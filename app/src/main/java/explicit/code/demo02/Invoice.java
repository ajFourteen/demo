package explicit.code.demo02;

import java.util.Collection;
import java.util.List;

public class Invoice {
    private Rest rest = new Rest();

    private Person recipient;
    private Collection<InvoiceItem> items;
    private String number;

    public Invoice(Person recipient, List<InvoiceItem> items, String number) {
        this.recipient = recipient;
        this.items = items;
        this.number = number;
    }

    public Person recipient() {
        return this.recipient;
    }

    public Collection<InvoiceItem> items() {
        return this.items;
    }

    public String number() {
        return this.number;
    }

    public void print() {
        StringBuilder printed = new StringBuilder()
                .append("No.: ").append(this.number()).append("\n")
                .append("To: ").append(this.recipient()).append("\n")
                .append("Items:").append("\n");
        items.stream()
                .map(InvoiceItem::toString)
                .forEachOrdered(item -> printed.append(item).append("\n"));
        printed.append("Net Amount: ").append(this.netAmount()).append("\n")
                .append("VAT: ").append(this.vat()).append("\n")
                .append("Total Amount: ").append(this.totalAmount());
        System.out.println(printed);
    }

    public boolean isPayed() {
        Response<Void> loginResponse = rest.post(
                "https://www.bank.de/auth",
                "{username: '1234567890',password: 'f0ur733n'}");
        if (loginResponse.isFailed()) {
            throw new NetworkException(loginResponse.code());
        }
        Response<Transfer[]> response = rest.get("https://www.bank.de/transactions");
        if (response.isFailed()) {
            throw new NetworkException(response.code());
        }
        Transfer[] transfers = response.body();
        for (Transfer transfer : transfers) {
            if (transfer.amount().value() == this.totalAmount() && transfer.subject().equals(this.number())) {
                return true;
            }
        }
        return false;
    }

    public int netAmount() {
        return this.items().stream()
                .map(InvoiceItem::amount)
                .reduce(Amount.ZERO, Amount::add)
                .value();
    }

    public double vat() {
        return this.items().stream()
                .map(InvoiceItem::vat)
                .reduce(0.0, (a, b) -> a + b);
    }

    public double totalAmount() {
        return this.netAmount() + this.vat();
    }
}
