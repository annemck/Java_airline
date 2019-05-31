import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Plane plane = new Plane(PlaneType.BOEING737);
    private Flight flight;

    @Before
    public void setup() {
        this.flight = new Flight(plane,
                "BA721",
                "LDN",
                "GLA",
                "13:20");
    }

    @Test
    public void flightHasPlane() {
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void flightHasFlightNumber() {
        assertEquals("BA721", flight.getFlightNumber());
    }

    @Test
    public void flightHasDestination() {
        assertEquals("LDN", flight.getDestination());
    }

    @Test
    public void flightHasDepartureAirport() {
        assertEquals("GLA", flight.getDepartureAirport());
    }

    @Test
    public void flightHasDepartureTime() {
        assertEquals("13:20", flight.getDepartureTime());
    }
}
