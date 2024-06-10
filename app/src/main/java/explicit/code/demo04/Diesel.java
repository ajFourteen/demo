package explicit.code.demo04;

record Diesel(int amount) implements Fuel<Diesel> {

    @Override
    public Diesel add(Diesel fuel) {
        return new Diesel(amount + fuel.amount());
    }

}
