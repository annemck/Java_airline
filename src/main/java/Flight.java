public class Flight {

    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private String departureTime;

    public Flight(Plane plane,
                  String flightNumber,
                  String destination,
                  String departureLocation,
                  String departureTime) {
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureLocation;
        this.departureTime = departureTime;
    }

    public Plane getPlane() {
        return this.plane;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDepartureAirport() {
        return this.departureAirport;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }
}
