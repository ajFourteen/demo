package explicit.code.demo01;

final class FruitStore {

    private int numberOfCustomers = 0;

    void accept(Customer customer) {
        this.numberOfCustomers++;
        customer.buy(new Apple());
        if (this.numberOfCustomers % 100 == 0 && customer.name().startsWith("A")) {
            customer.getAsAGift(new Banana());
        }
    }
}
