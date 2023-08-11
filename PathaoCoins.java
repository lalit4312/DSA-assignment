// 1.b)
// A group of n Pathao riders stood in a queue, and each rider was assigned a unique integer rating based on their
// performance over the year. The Pathao company planned to distribute gold coins to each rider in ascending order,
// starting from count 1. The riders with higher ratings should receive more coins than their neighboring riders. The
// objective was to determine the minimum number of coins required by Pathao to distribute coins to the selected
// riders according to their ratings.
// Input: ratings = [1,0,2]
// Output: 5
// Explanation: You can give the first, second, and third rider 2, 1, 2 gold coins, respectively.

import java.util.Arrays;

public class PathaoCoins {
    public static void main(String[] args) {
        int[] ratings = { 1, 0, 2 };
        int minimumCoins = minimumCoins(ratings);
        System.out.println("Minimum number of coins required: " + minimumCoins);
    }

    public static int minimumCoins(int[] ratings) {
        int n = ratings.length;
        int[] coins = new int[n]; // Initialize an array to store coins for each person
        Arrays.fill(coins, 1); // Everyone starts with at least 1 coin

        // Traverse forward to assign more coins to people with higher ratings
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                coins[i] = coins[i - 1] + 1;
            }
        }

        // Traverse backward to ensure fairness for people with decreasing ratings
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && coins[i] <= coins[i + 1]) {
                coins[i] = coins[i + 1] + 1;
            }
        }

        int totalCoins = 0;
        for (int coinsCount : coins) {
            totalCoins += coinsCount; // Calculate the total number of coins needed
        }

        return totalCoins;
    }
}
