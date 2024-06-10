package explicit.code.demo04;

final class SportsCar implements Car<Petrol> {

    private Petrol refueledPetrol = new Petrol(0); 

    @Override
    public void refuel(Petrol fuel) {
        refueledPetrol = refueledPetrol.add(fuel);
    }

    @Override
    public int fuelLevel() {
        return refueledPetrol.amount();
    }

}
