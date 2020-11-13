import apiCalls.enums.TrafficArea;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test {

    @org.junit.Test
    public void some() {
        assertTrue(TrafficArea.getPostCode(TrafficArea.valueOf(TrafficArea.NORTH_EAST.name())).contains("BD"));
    }
}
