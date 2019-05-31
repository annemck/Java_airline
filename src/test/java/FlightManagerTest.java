import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private Plane plane = new Plane(PlaneType.TESTPLANE);
    private Flight flight = new Flight(plane,
            "BA721",
            "LDN",
            "GLA",
            "13:20");
    private FlightManager flightManager;
    private Passenger passenger;

    @Before
    public void setup() {
        flightManager = new FlightManager(flight);
        passenger = new Passenger("Joe", 1);
    }

    @Test
    public void canGetTotalWeightReservedForBags() {
        assertEquals(20, flightManager.getReservedBaggageWeight());
    }

    @Test
    public void canGetIndividualPassengerReservedBaggageWeight() {
        assertEquals(10, flightManager.getPassengerBaggageLimit());
    }


    @Test
    public void canGetRemainingWeightAvailableForBags() {
        flightManager.getFlight().bookPassenger(passenger);
        assertEquals(10, flightManager.getRemainingBaggageWeight());
    }
}
