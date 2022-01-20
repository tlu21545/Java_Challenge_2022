import java.util.ArrayList;
import java.util.Arrays;

public class Die {
    
    // Represents probability of rolling a certain number
    // [1, 2, 3, 4, 5, 6] is a standard 6 sided die
    // [1, 1, 2, 3, 4, 5, 6] is a 6 sided die that is twice as likely to roll 1
    ArrayList<Integer> dieWeights = new ArrayList<Integer>();

    // Stores last number rolled, -1 by default
    int lastRoll = -1;
    
    // Constructs standard 6 sided die
    public Die() {
        for (int i = 0; i < 6; i++) {
            dieWeights.add(i + 1);
        }
    }

    // Constructs standard n sided die
    public Die(int sides) {
        for (int i = 0; i < sides; i++) {
            dieWeights.add(i + 1);
        }
    }

    // Constructs weighted n sided die
    public Die(Integer... nums) {
        for (int num : nums) {
            dieWeights.add(num);
        }
    }

    // Returns number of sides
    public int getSides() {
        int numSides = 0;
        for (int dieWeight : dieWeights) {
            if (dieWeight > numSides) {
                numSides = dieWeight;
            }
        }
        return numSides;
    }

    // Returns roll
    public int getRoll() {
        lastRoll = dieWeights.get((int) (Math.random() * dieWeights.size()));
        return lastRoll;
    }

    // Returns n rolls
    public String getRoll(int numRolls) {
        int[] tempList = new int[numRolls];
        for (int i = 0; i < numRolls; i++) {
            lastRoll = dieWeights.get((int) (Math.random() * dieWeights.size()));
            tempList[i] = lastRoll;
        }
        
        return Arrays.toString(tempList);
    }

    // Returns last number rolled
    public int getLastRoll() {
        return lastRoll;
    }

    // Returns frequency of each value in n rolls
    public String getFrequency(int numRolls) {
        int[] frequencyList = new int[getSides()];
        for (int i = 0; i < numRolls; i++) {
            lastRoll = getRoll();
            frequencyList[lastRoll - 1]++;
        }
        return Arrays.toString(frequencyList);
    }

    // Returns sum of n rolls
    public int getSum(int numRolls) {
        int sum = 0;
        for (int i = 0; i < numRolls; i++) {
            lastRoll = getRoll();
            sum += lastRoll;
        }
        return sum;
    }

    // Returns average of n rolls
    public double getAverage(int numRolls) {
        int sum = 0;
        for (int i = 0; i < numRolls; i++) {
            lastRoll = getRoll();
            sum += lastRoll;
        }
        return (double) sum / numRolls;
    }

    public static void main(String[] args) {
        Die six = new Die();
        Die four = new Die(4);
        Die sevenWeight = new Die(1, 1, 2, 3, 4, 4, 4, 5, 6, 7);

        System.out.println("Sides: " + six.getSides());
        System.out.println("Sides: " + four.getSides());
        System.out.println("Sides: " + sevenWeight.getSides());

        System.out.println("Roll: " + six.getRoll());
        System.out.println("Roll: " + four.getRoll());
        System.out.println("Roll: " + sevenWeight.getRoll());

        System.out.println("20 rolls: " + six.getRoll(20));
        System.out.println("20 rolls: " + four.getRoll(20));
        System.out.println("20 rolls: " + sevenWeight.getRoll(20));

        System.out.println("Last roll: " + six.getLastRoll());
        System.out.println("Last roll: " + four.getLastRoll());
        System.out.println("Last roll: " + sevenWeight.getLastRoll());

        System.out.println("Frequency in 100000 rolls: " + six.getFrequency(100000));
        System.out.println("Frequency in 100000 rolls: " + four.getFrequency(100000));
        System.out.println("Frequency in 100000 rolls: " + sevenWeight.getFrequency(100000));

        System.out.println("Sum of 100000 rolls: " + six.getSum(100000));
        System.out.println("Sum of 100000 rolls: " + four.getSum(100000));
        System.out.println("Sum of 100000 rolls: " + sevenWeight.getSum(100000));

        System.out.println("Average of 100000 rolls: " + six.getAverage(100000));
        System.out.println("Average of 100000 rolls: " + four.getAverage(100000));
        System.out.println("Average of 100000 rolls: " + sevenWeight.getAverage(100000));
    }
}