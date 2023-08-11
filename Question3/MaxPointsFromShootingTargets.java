package Question3;// Question 3
// a) Suppose you are provided an array of n targets that are placed in a row from 0 to n-1. Each target is assigned
// with certain integer such that a [0] represent the value associated with target zero. You are asked to shoot all
// the targets. If you shoot I th target then you will get a[i-1]*a[i]*a[i+1] points.
// Note that if i-1 and i+1 position hits index out of bound, then you can assume that two target with value 1 are
// padded before start target and after end target.
// Return maximum point one can gain by hitting each target.
// Input: a = [3,1,5,8]
// Output: 167
// Explanation:
// a = [3,1,5,8]
// [3,1,5,8] points 3*1*5 (“hitting target with value 1”)
// [3,5,8] points 3*5*8 (“hitting target with value 5”)
// [3,8] points 1*3*8 (“hitting target with value 3”) note that there is padded target with value 1 at beginning and end
// of the provided target list
// ,[8] points 1*8*1 same as above
// points = 3*1*5+ 3*5*8 + 1*3*8 + 1*8*1 = 167

public class MaxPointsFromShootingTargets {
    public static int maxPoints(int[] a) {
        int n = a.length;

        // Create a new array with padded targets at the beginning and end
        int[] paddedTargets = new int[n + 2];
        paddedTargets[0] = paddedTargets[n + 1] = 1;
        System.arraycopy(a, 0, paddedTargets, 1, n);

        // Create a 2D array to store the dynamic programming results
        int[][] dp = new int[n + 2][n + 2];

        // Perform dynamic programming to calculate the maximum points
        for (int len = 1; len <= n; len++) {
            for (int left = 1; left <= n - len + 1; left++) {
                int right = left + len - 1;
                for (int i = left; i <= right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                            dp[left][i - 1] + paddedTargets[left - 1] * paddedTargets[i] * paddedTargets[right + 1]
                                    + dp[i + 1][right]);
                }
            }
        }

        // The result is stored in the top-right corner of the dp array
        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] a = { 3, 1, 5, 8 };
        int result = maxPoints(a);
        System.out.println("Maximum points: " + result);
    }
}
