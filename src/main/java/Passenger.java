public class Passenger {

    private String name;
    private int bags;

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
}
