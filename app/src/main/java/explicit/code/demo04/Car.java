package explicit.code.demo04;

interface Car<F extends Fuel<?>> {

    /**
     * The fuel level will be increased by the given amount of fuel
     * 
     * @param fuel
     */
    void refuel(F fuel);

    int fuelLevel();
}
