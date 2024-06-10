package explicit.code.demo01;

final class FruitStore {

    void accept(Customer customer) {
        customer.buy(new Apple());
    }
}
