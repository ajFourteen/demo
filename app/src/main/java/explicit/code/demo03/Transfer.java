package explicit.code.demo03;

final class Transfer {
    private final String subject;
    private final Amount amount;

    public Transfer(String subject, Amount amount) {
        this.subject = subject;
        this.amount = amount;
    }

    public String subject() {
        return this.subject;
    }

    public Amount amount() {
        return this.amount;
    }
}
