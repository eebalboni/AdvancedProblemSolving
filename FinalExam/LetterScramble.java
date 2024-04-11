/***********
* LetterScramble
* Author: 
*
* SER305 - Spring 2023, Starting Code
* Analysis: Analyze your solution's time and (additional) space efficiency in terms of n and s.
*    k = number of cases (ignore, analyze time PER case)
*    n = the length of the message M
*    s = the number of instructions to process for that message
*    Note "additional" space does not incude the input itself.
*  Time:
*  Space:
*  Explanation: 
***********/
import java.util.Scanner;

public class LetterScramble {
    public static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);   // The one and only Scanner to use!

        // Read in the number of cases
        int cases = sc.nextInt();
        sc.nextLine();  // Munch up the new line!

        for (int i = 0; i < cases; i++)
            processCase();
    }

    private static void processCase() {
        // Process this specific case
        String letters = sc.nextLine();  // Read in the WORD
        int steps = sc.nextInt();        // Read in the number of steps
        sc.nextLine();  // Munch up the new line!

        System.out.println("DEBUG: Unscrambling " + letters);
        for (int i = 0; i < steps; i++) {
            // Read in each step command - splitting at the spaces
            String command[] = sc.nextLine().split(" ");

            // Process each step
            System.out.print("DEBUG: Command: " + command[0]);
            for (int j = 1; j < command.length; j++) {
                int argValue = Integer.parseInt(command[j]);
                System.out.print(" Arg " + j + ":" + argValue);
            }
            System.out.println();
        }
    }
}
