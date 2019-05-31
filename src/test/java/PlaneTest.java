import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane;

    @Before
    public void setup() {
        this.plane = new Plane(PlaneType.AIRBUSA300);
    }

    @Test
    public void planeHasCapacity() {
        PlaneType planeType = plane.getPlaneType();
        assertEquals(330, planeType.getCapacity());
    }

    @Test
    public void planeStartsWithWeight() {
        PlaneType planeType = plane.getPlaneType();
        assertEquals(150000, planeType.getWeight());
    }
}
