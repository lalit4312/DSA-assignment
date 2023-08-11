
//5.a a) Implement hill climbing algorithm
import java.util.Random;
public class HillClimbing {
    public static void main(String[] args) {
        char[] best = generateRandomSolution(13); //initially it will generate random solutions(characters)
        int bestScore = evaluate(best);// compare best with targeted solution and return result

        while (true) {
            System.out.println("Best score so far: " + bestScore +
                    "Solution: " + new String(best));

            if (bestScore == 0) { // if best matches with target solution loop will terminate
                break;
            }
            // if not then
            char[] newSolution = best.clone();  // copy the generated solution in variable and mutate the solution
            mutateSolution(newSolution);

            int score = evaluate(newSolution);

            if (score < bestScore) {//comparing prevoius scrore with new score
                best = newSolution;
                bestScore = score;
            }
        }
    }
    public static char[] generateRandomSolution(int length) { // generate random character with fixed length
        char[] solution = new char[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            solution[i] = (char) (random.nextInt(94) + 32);
        }

        return solution;
    }
    // Evaluates the difference (score) between a solution and the target string
    public static int evaluate(char[] solution) {
        String target = "Hello, World!";
        int diff = 0;

        for (int i = 0; i < target.length(); i++) {
            char s = solution[i];
            char t = target.charAt(i);
            diff += Math.abs((int) s - (int) t);// Calculate the absolute difference between ASCII values
        }

        return diff;
    }
    // Mutates a solution by randomly changing a character
    public static void mutateSolution(char[] solution) {
        Random random = new Random();
        int index = random.nextInt(solution.length);
        solution[index] = (char) (random.nextInt(94) + 32);
    }
}
