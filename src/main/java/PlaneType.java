public enum PlaneType {

    BOEING737(180, 80000),
    AIRBUSA320(150, 50000),
    BOEING747(400, 150000),
    AIRBUSA300(330, 150000);

    private final int capacity;
    private final int totalWeight;

    PlaneType(int capacity, int totalWeight) {
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

   public int getCapacity(){
        return this.capacity;
   }

   public int getWeight(){
        return this.totalWeight;
   }
}
