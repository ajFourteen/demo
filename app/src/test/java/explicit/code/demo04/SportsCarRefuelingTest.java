package explicit.code.demo04;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;

final class SportsCarRefuelingTest {

    @Test
    void aSportsCarWithAnEmptyFuelTank_isRefueledWith10LitersPetrol_thenTheTankLevelIs10Liters() {
        SportsCar sportsCar = new SportsCar();
        assumeTrue(sportsCar.fuelLevel() == 0);
        Petrol tenLiters = new Petrol(10);

        sportsCar.refuel(tenLiters);

        assertThat(sportsCar.fuelLevel()).isEqualTo(10);
    }
}
