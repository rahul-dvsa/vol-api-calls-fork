import apiCalls.enums.TrafficArea;

public class Test {

    @org.junit.Test
    public void some() {
        System.out.println(TrafficArea.getPostCode(TrafficArea.NORTH_EAST.asString()));
    }
}
