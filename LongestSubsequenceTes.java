import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestSubsequenceTes {
    @Test
    public void testLongestSubsequence() {
        int[] nums = {8, 5, 4, 2, 1, 4, 3, 4, 3, 1, 15};
        int k = 2;
        int expected = 4; // The longest subsequence is {5, 4, 3, 1}.

        int result = LongestSubsequence.longestSubsequence(nums, k);
        assertEquals(expected, result);
    }
}
