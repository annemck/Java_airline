import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;

    @Before
    public void setup() {
        this.passenger = new Passenger("Joe", 2);
    }

    @Test
    public void passengerHasName() {
        assertEquals("Joe", passenger.getName());
    }

    @Test
    public void passengerHasBags() {
        assertEquals(2, passenger.getNumberOfBags());
    }
}
