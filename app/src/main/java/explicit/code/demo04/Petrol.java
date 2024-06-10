package explicit.code.demo04;

record Petrol(int amount) implements Fuel<Petrol> {

    @Override
    public Petrol add(Petrol fuel) {
        return new Petrol(amount + fuel.amount());
    }

}
