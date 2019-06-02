import java.util.ArrayList;

public class FlightManager {

    private Flight flight;

    public FlightManager(Flight flight) {
        this.flight = flight;
    }

    public Flight getFlight(){
        return this.flight;
    }

    public int getReservedBaggageWeight() {
        Plane plane = this.flight.getPlane();
        return plane.getWeight()/2;
    }

//    weight rounds down as better to be underweight than overweight on a plane (I assume)
    public int getPassengerBaggageLimit() {
        int totalWeight = this.getReservedBaggageWeight();
        Plane plane = this.getFlight().getPlane();
        int capacity =  plane.getCapacity();
        return totalWeight/capacity;
    }

//    assuming each bag weighs 10kg
    public int getRemainingBaggageWeight() {
        Flight flight = this.getFlight();
        int bags = flight.getNumberOfBags() * 10;
        return this.getReservedBaggageWeight() - bags;
    }

    public ArrayList<Passenger> sortPassengers() {
        Flight flight = this.getFlight();
        ArrayList<Passenger> passengers = flight.getPassengers();
        ArrayList<Passenger> sortedPassengers = new ArrayList<Passenger>(passengers.size());
        for (int i = 0; i < passengers.size(); i++){
            for (int nextIndex = 1; nextIndex < passengers.size(); nextIndex++){
                Passenger firstPassenger = passengers.get(i);
                Passenger secondPassenger = passengers.get(nextIndex);
                if (!sortedPassengers.contains(firstPassenger)) {
                    sortedPassengers.add(firstPassenger);
                }
                if (!sortedPassengers.contains(secondPassenger)) {
                    sortedPassengers.add(secondPassenger);
                }
                if (firstPassenger.getSeat() > secondPassenger.getSeat()){
                    sortedPassengers.set(i, secondPassenger);
                    sortedPassengers.set(nextIndex, firstPassenger);
                }
            }
        }
        return sortedPassengers;
    }

    public Passenger getPassenger(int seat) {
        ArrayList<Passenger> sortedPassengers = this.sortPassengers();
        Passenger passenger = this.binarySearch(sortedPassengers, seat);
        return passenger;
    }

    private Passenger binarySearch(ArrayList<Passenger> passengers, int seat){
        if (passengers.size() == 0){
            return null;
        }

        int midIndex = passengers.size() / 2;
        Passenger passenger = passengers.get(midIndex);

        if (passenger.getSeat() == seat){
            return passenger;
        }

        ArrayList<Passenger> shortList;
        if (seat > passenger.getSeat()){
            shortList = new ArrayList<Passenger>(passengers.subList(midIndex + 1, passengers.size()));
        } else {
            shortList = new ArrayList<Passenger>(passengers.subList(0, midIndex));
        }
        return binarySearch(shortList, seat);

    }
}
