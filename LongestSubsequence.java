// Question 2
// a)
// Given an integer array nums and another integer k, the goal is to find the longest subsequence of nums that
// satisfies the following two conditions:
// The subsequence is strictly decreasing.
// The difference between adjacent elements in the subsequence is at most k.
// The output should be the length of the longest subsequence that meets these requirements.
// For example, consider the following input:
// nums = [8,5,4, 2, 1, 4, 3, 4, 3, 1, 15] k = 3
// output=[8,5,4,2,1] or [8,5,4,3,1]
// Output: 5
// Explanation:
// The longest subsequence that meets the requirements is [8,5,4,2,1] or [8,5,4,3,1].
// The subsequence has a length of 5, so we return 5.
// Note that the subsequence [1,3,4,5,8,15] does not meet the requirements because 15 - 8 = 7 is larger than 3.

public class LongestSubsequence {
    public static void main(String[] args) {
        int[] nums = { 8, 5, 4, 2, 1, 4, 3, 4, 3, 1, 15 };
        int k = 3;
        // Call the 'longestSubsequence' method with 'nums' and 'k' as arguments and
        // print the result.
        System.out.println(longestSubsequence(nums, k));
    }

    public static int longestSubsequence(int[] nums, int k) {
        int n = nums.length;
        // Create an array 'dp' to store the length of the longest subsequence ending at
        // each index.
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            // Initialize a variable 'maxLen' to keep track of the maximum length of
            // subsequence ending at the current index 'i'.
            int maxLen = 0;
            for (int j = 0; j < i; j++) {
                // Iterate through all elements before the current index 'i' to find elements
                // that are smaller than nums[i]
                // and their difference is less than or equal to 'k'.
                if (nums[i] < nums[j] && nums[j] - nums[i] <= k) {
                    // Update 'maxLen' to store the maximum subsequence length among valid
                    // candidates.
                    maxLen = Math.max(maxLen, dp[j]);
                }
            }
            // Store the longest subsequence length ending at the current index 'i' in the
            // 'dp' array.
            dp[i] = maxLen + 1;
        }

        int maxLength = 0;
        for (int len : dp) {
            // Find the maximum subsequence length among all elements in the 'dp' array.
            maxLength = Math.max(maxLength, len);
        }
        // Return the overall maximum subsequence length.
        return maxLength;
    }

}