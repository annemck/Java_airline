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
        assertEquals(330, plane.getCapacity());
    }

    @Test
    public void planeStartsWithWeight() {
        assertEquals(150000, plane.getWeight());
    }


}
