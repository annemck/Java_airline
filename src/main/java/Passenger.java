public class Passenger {

    private String name;
    private int bags;
    private Flight flight;
    private int seatNumber;

    public Passenger(String name, int numberOfBags) {
        this.name = name;
        this.bags = numberOfBags;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfBags() {
        return this.bags;
    }

    public void addFlight(Flight flight){
        this.flight = flight;
    }

    public void addSeat(int seatNumber){
        this.seatNumber = seatNumber;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public int getSeat(){
        return this.seatNumber;
    }
}
