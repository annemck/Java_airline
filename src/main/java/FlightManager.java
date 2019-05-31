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
}
