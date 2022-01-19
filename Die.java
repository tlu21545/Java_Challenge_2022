// Question Two

import java.util.Arrays;

public class Die {
    int sides;

    // Creates 6 sided die
    public Die() {
        sides = 6;
    }

    // Creates n sided die
    public Die(int sides) {
        this.sides = sides;
    }

    // Returns # of sides of die
    // let's change method signature to "public int getNumSides()" since it is a getter method that returns something
    int numSides() {
        return sides;
    }

    // Returns random die roll
    // add public scope for this method so can call from outside this class if we wanted
    // (always declare a method as either private or public)
    // also let's rename to "getRoll" since it returns something
    int roll() {
        return (int)(Math.random() * sides + 1);
    }

    // Rolls die n times and averages rolls
    // add public scope like above and rename to "getAverageRolls"
    double averageRolls(int rolls) {
        int tempSum = 0;
        for (int i = 0; i < rolls; i++) {
            tempSum += roll();
        }
        return (double) tempSum / rolls;
    }

    // Returns number of each value in n rolls
    // add public and rename to "getValuesList"
    String valuesList(int rolls) {
        int[] valuesList = new int[this.sides];
        for (int i = 0; i < rolls; i++) {
            valuesList[roll() - 1]++;
        }
        return Arrays.toString(valuesList);
    }

    public static void main(String[] args) {
        // Create standard die, four sided die, and nine sided die
        Die standard = new Die();
        Die fourSides = new Die(4);
        Die nineSides = new Die(9);

        // Print sides and random roll for all three dice
        System.out.println("Sides: " + standard.numSides() + " Roll: " + standard.roll());
        System.out.println("Sides: " + fourSides.numSides() + " Roll: " + fourSides.roll());
        System.out.println("Sides: " + nineSides.numSides() + " Roll: " + nineSides.roll());

        // Prints average of 1000 rolls for all three dice
        System.out.println("Standard die average of 1000 roles: " + standard.averageRolls(1000));
        System.out.println("Four sided die average of 1000 roles: " + fourSides.averageRolls(1000));
        System.out.println("Nine sided die average of 1000 roles: " + nineSides.averageRolls(1000));
        
        // Prints number of each value in 10000 rolls for all three dice
        System.out.println("Number of each value in 10000 rolls on standard die: " + standard.valuesList(10000));
        System.out.println("Number of each value in 10000 rolls on four sided die: " + fourSides.valuesList(10000));
        System.out.println("Number of each value in 10000 rolls on nine sided die: " + nineSides.valuesList(10000));
    }
}
