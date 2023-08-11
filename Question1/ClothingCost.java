package Question1;// 1.a)
// A trio of friends planned to purchase clothing from a particular store for an upcoming party, intending to wear
// matching outfits in varying colors - black, blue, and pink. The store had three different clothing sets on display,
// each in a different color. The shopkeeper assisted the three friends by selecting a clothing set in the appropriate
// color for each person based on their body shape and size. Given a 2D array, price[][3], where price[i][0],
// price[i][1], and price[i][2] represent the price of each clothing set for a different colored outfit for person i, your
// objective is to determine the minimum cost required to purchase clothing such that each person wears have
// different color clothes if they stand in a row.
// It should be noted that any two people can wear the same color cloth, but the third person must wear various
// color cloths, and all three can wear different colored garments.
// Input: N = 3, price[][3] = [{14, 4, 11}, {11, 14, 3}, {14, 2, 10}]
// Output: 9
// Explanation:
// Person 1 chooses blue clothing cost=4. Person 2 chooses pink clothing. Cost = 3. Person 3 chooses blue
// clothing. Cost = 2.
// As a result, the total cost = 2 + 5 + 3 = 9.
// Note: algorithm must take
// Time Complexity: O(N)
// Auxiliary Space: O(1)

public class ClothingCost {
    public static void main(String[] args) {
        int[][] price = {
                { 14, 4, 11 },
                { 11, 14, 3 },
                { 14, 2, 10 }
        };
        int minimumCost = minimumCost(price);
        System.out.println("Minimum cost required: " + minimumCost);
    }

    public static int minimumCost(int[][] price) {
        int minCost1 = 0; // Initialize minimum cost if person chooses clothing type 1
        int minCost2 = 0; // Initialize minimum cost if person chooses clothing type 2
        int minCost3 = 0; // Initialize minimum cost if person chooses clothing type 3

        for (int[] person : price) {
            // Calculate the new minimum costs for each clothing type based on previous
            // choices
            int newMinCost1 = person[0] + Math.min(minCost2, minCost3);
            int newMinCost2 = person[1] + Math.min(minCost1, minCost3);
            int newMinCost3 = person[2] + Math.min(minCost1, minCost2);

            // Update the minimum costs for the next iteration
            minCost1 = newMinCost1;
            minCost2 = newMinCost2;
            minCost3 = newMinCost3;
        }

        // Return the overall minimum cost among the three clothing types
        return Math.min(minCost1, Math.min(minCost2, minCost3));
    }
}
