import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class Flight {

    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private Date departureTime;
    private ArrayList<Passenger> passengers;
    private ArrayList<Integer> seats;

    public Flight(Plane plane,
                  String flightNumber,
                  String destination,
                  String departureLocation,
                  String departureTime) {
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureLocation;
        SimpleDateFormat time = new SimpleDateFormat("hh:mm");
        try {
            this.departureTime = time.parse(departureTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.passengers = new ArrayList<Passenger>();
        this.populateSeats();
    }

    private void populateSeats() {
        Plane plane = this.getPlane();
        int capacity = plane.getCapacity();
        this.seats = new ArrayList<Integer>(capacity);
        for (int seat = 1; seat <= capacity; seat++){
            this.seats.add(seat);
        }
    }

    public int getTotalNumberOfSeats(){
        return this.seats.size();
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

//    Don't quite understand where the string is coming from here, but changed it to string due to IDE alerts.
    public String getDepartureTime() {
        Date date = this.departureTime;
        String time = new SimpleDateFormat("HH:mm").format(date);
        return time;
    }

    public int getPassengerNumbers(){
        return this.passengers.size();
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    public boolean bookPassenger(Passenger passenger) {
        if (this.numberOfSeatsAvailable() != 0) {
            this.assignSeat(passenger);
            passenger.addFlight(this);
            return this.passengers.add(passenger);
        }
        return false;
    }

    private void assignSeat(Passenger passenger) {
        Random number = new Random();
        int index = number.nextInt(this.seats.size());
        int seat = this.seats.get(index);
        this.seats.remove(index);
        passenger.addSeat(seat);
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
