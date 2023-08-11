import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxPointsFromShootingTargetsTest {
    @Test
    public void testMaxPoints() {
        int[] targets = {3, 1, 5, 8};
        int expectedMaxPoints = 167; // The maximum points achievable by shooting at the targets.

        int result = MaxPointsFromShootingTargets.maxPoints(targets);
        assertEquals(expectedMaxPoints, result);
    }
}
