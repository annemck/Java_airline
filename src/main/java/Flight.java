import java.util.ArrayList;

public class Flight {

    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private String departureTime;
    private ArrayList<Passenger> passengers;

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
        this.passengers = new ArrayList<Passenger>();
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

    public int getPassengerNumbers(){
        return this.passengers.size();
    }

    public boolean bookPassenger(Passenger passenger) {
        if (this.numberOfSeatsAvailable() != 0) {
            return this.passengers.add(passenger);
        }
        return false;
    }

    public int numberOfSeatsAvailable() {
        Plane plane = this.getPlane();
        PlaneType planeType = plane.getPlaneType();
        int capacity = planeType.getCapacity();
        return capacity - this.getPassengerNumbers();
    }

    public int getNumberOfBags() {
        int total = 0;
        for (Passenger passenger : passengers) {
            total += passenger.getNumberOfBags();
        }
        return total;
    }
}
