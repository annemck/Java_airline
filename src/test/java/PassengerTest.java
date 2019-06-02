import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PassengerTest {

    private Passenger passenger;

    @Before
    public void setup() {
        this.passenger = new Passenger("Joe", 2);
    }
    Plane plane = new Plane(PlaneType.TESTPLANE);
    Flight flight = new Flight(plane,
            "A123",
            "LDN",
            "GLA",
            "10:00");

    @Test
    public void passengerHasName() {
        assertEquals("Joe", passenger.getName());
    }

    @Test
    public void passengerHasBags() {
        assertEquals(2, passenger.getNumberOfBags());
    }

    @Test
    public void passengerGetsFlightPropertyWhenBookedOnFlight() {
        flight.bookPassenger(passenger);
        assertEquals(flight, passenger.getFlight());
    }

    @Test
    public void passengerGetsSeatNumberWhenBookedOnFlight() {
        flight.bookPassenger(passenger);
        assert passenger.getSeat() == 1 || passenger.getSeat() == 2;
    }

    @Test
    public void passengersDoNotGetAssignedSameSeat() {
        flight.bookPassenger(passenger);
        Passenger passenger2 = new Passenger("Mary", 0);
        flight.bookPassenger(passenger2);
        assertNotEquals(passenger.getSeat(), passenger2.getSeat());
    }
}
