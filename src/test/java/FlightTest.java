import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlightTest {

    private Plane plane = new Plane(PlaneType.TESTPLANE);
    private Flight flight;
    private Passenger passenger;

    @Before
    public void setup() {
        this.flight = new Flight(plane,
                "BA721",
                "LDN",
                "GLA",
                "13:20");
        this.passenger = new Passenger("Joe", 2);
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

    @Test
    public void passengerListStartsEmpty() {
        assertEquals(0, flight.getPassengerNumbers());
    }

    @Test
    public void canBookPassengerOnFlight() {
        assertTrue(flight.bookPassenger(passenger));
        assertEquals(1, flight.getPassengerNumbers());
    }

    @Test
    public void canGetNumberOfAvailableSeats() {
        assertEquals(2, flight.numberOfSeatsAvailable());
        flight.bookPassenger(passenger);
        assertEquals(1, flight.numberOfSeatsAvailable());
    }

    @Test
    public void cannotBookPassengerOnFullFlight() {
        flight.bookPassenger(passenger);
        Passenger passenger2 = new Passenger("Mary", 1);
        flight.bookPassenger(passenger2);
        Passenger passenger3 = new Passenger("John", 2);
        assertFalse(flight.bookPassenger(passenger3));
    }
}
