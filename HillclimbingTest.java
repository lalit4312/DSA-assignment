import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HillclimbingTest {
    @Test
    public void evaluateWithMatchingSolution() {
        char[] solution = "Hello, World!".toCharArray();
        int result = HillClimbing.evaluate(solution);
        assertEquals(0, result);
    }
    @Test
    public void evaluateWithDifferentSolution() {
        char[] solution = "Hdllo, Wwrld!".toCharArray();
        int result = HillClimbing.evaluate(solution);
        assertEquals(10, result);
    }

    @Test
    public void evaluateWithEmptySolution() {
        char[] solution = new char[0];
        int result = HillClimbing.evaluate(solution);
        assertEquals(0, result);
    }
}
