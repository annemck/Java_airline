public class Plane {

    private PlaneType planeType;

    public Plane(PlaneType planeType) {
        this.planeType = planeType;
    }

    public PlaneType getPlaneType() {
        return this.planeType;
    }

    public int getCapacity() {
        PlaneType planeType = this.getPlaneType();
        return planeType.getCapacity();
    }


    public int getWeight() {
        PlaneType planeType = this.getPlaneType();
        return planeType.getWeight();
    }
}
