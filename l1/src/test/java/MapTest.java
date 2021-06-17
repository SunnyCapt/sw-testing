import models.AwesomeType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    @Test
    public void testMyMap() {

        BestMap<AwesomeType, String> bestMap = new BestMap<AwesomeType, String>();
        Map<AwesomeType, String> expectedMap = new HashMap<AwesomeType, String>();

        Assertions.assertEquals(expectedMap.isEmpty(), bestMap.isEmpty());
        Assertions.assertEquals(expectedMap.size(), bestMap.size());

        bestMap.add(new AwesomeType("a"), "abcd");
        bestMap.add(new AwesomeType("b"), "bcda");
        bestMap.add(new AwesomeType("c"), "cdab");
        bestMap.add(new AwesomeType("d"), "dabc");

        expectedMap.put(new AwesomeType("a"), "abcd");
        expectedMap.put(new AwesomeType("b"), "bcda");
        expectedMap.put(new AwesomeType("c"), "cdab");
        expectedMap.put(new AwesomeType("d"), "dabc");

        Assertions.assertEquals(expectedMap.isEmpty(), bestMap.isEmpty());
        Assertions.assertEquals(expectedMap.size(), bestMap.size());
        Assertions.assertEquals(expectedMap.get(new AwesomeType("b")), bestMap.get(new AwesomeType("b")));
        Assertions.assertEquals(expectedMap.remove(new AwesomeType("c")), bestMap.remove(new AwesomeType("c")));

        bestMap.add(new AwesomeType("c"), "eatable");
        bestMap.add(new AwesomeType("c"), "enable");
        expectedMap.put(new AwesomeType("c"), "eatable");
        expectedMap.put(new AwesomeType("c"), "enable");
        Assertions.assertEquals(expectedMap.get(new AwesomeType("c")), bestMap.get(new AwesomeType("c")));
        System.out.println(expectedMap);
    }
}
