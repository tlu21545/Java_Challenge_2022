// Question One

public class BasicDie {

    // Returns a random integer from 1 to 6
    private static double roll() {
        return (int)(Math.random() * 6 + 1);
    }

    // Prints 20 die rolls
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(roll());
        }
    }
}