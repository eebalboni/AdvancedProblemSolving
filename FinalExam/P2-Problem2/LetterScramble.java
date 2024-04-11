/***********
* LetterScramble
* Author: Emily Balboni
*
* SER305 - Spring 2023, Starting Code
* Analysis: Analyze your solution's time and (additional) space efficiency in terms of n and s.
*    k = number of cases (ignore, analyze time PER case)
*    n = the length of the message M
*    s = the number of instructions to process for that message
*    Note "additional" space does not incude the input itself.
*  Time: First, in my algorithm I take the string provided and change it to a string builder which takes constant time. 
Then the program loops through the number of steps per word. This takes theta(s) time. Within this loop, I also loop through the 
command to store the indexes of letters to be swapped or the number of rotations in an array. This loop is always size 1 or 2, because you 
at most can have 2 points or at least have 1 rotation, but no swap will have only 1 index provided. Once that is done, 
I use an if statement to determine what call needs to be made for what operation. 
The swap method takes theta(n). It simply stores the current index in a temp variable. Then it replaces that index with the other provided
then the other variable is replaced with the temp. The rotate method also takes theta(n). This is because 
I used the number of rotations to divide the message into two parts and then append them back together. 
The reverse method uses the StringBuilders reverse method. This method takes theta(n). The final method, move also takes 
theta(n) time. I stored the character to be inserted in a temp variable, deleted it from the string, then inserted it at 
the index provided using the StringBuilder delete and insert methods.
Overall, the time if going to take theta(s*n). This is because you loop through the steps and each step will have an theta(n) method call.
*  Space: I used a StringBuilder variable that was the length of the message so I could use the StringBuilder class methods.
So extra space would be of n. 
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
        
        StringBuilder str = new StringBuilder(letters);
        
       // System.out.println("DEBUG: Unscrambling " + letters);
        for (int i = 0; i < steps; i++) {
            // Read in each step command - splitting at the spaces
            String command[] = sc.nextLine().split(" ");
            int [] indexes = new int [2]; //want to recreate for each step 
            int temp = 0;
            // Process each step
            //System.out.print("DEBUG: Command: " + command[0]);
            for (int j = 1; j < command.length; j++) {
                int argValue = Integer.parseInt(command[j]);
                //System.out.print(" Arg " + j + ":" + argValue);
                //putting indexes into an array to be referenced easier
                indexes[temp] = argValue;
                temp ++;
            }
            if(command[0].equals("swap")){
                //System.out.println("Before: " + str);
                str = swap(str,indexes);
                //System.out.println("swapped: " + str);
            }else if(command[0].equals("rotate")){
                //only taking one int value 
                str = rotate(str, indexes[0]);
                //System.out.println("rotated: " + str);
            }else if(command[0].equals("reverse")){
               str = reverse(str, indexes);
               //System.out.println("reversed: " + str);
            }else if(command[0].equals("move")){
                move(str,indexes);
                //System.out.println("moved: " + str);
                //System.out.println("move: " + indexes[0] + " and: " + indexes[1]);
            }else{
                System.out.println("Invalid command");
            }
        }
        System.out.println(str);
    }

    //swap method, done and works
    public static StringBuilder swap (StringBuilder word, int [] points){
        //System.out.println("word length: " + word.length());
        int index1 = points[0];
        int index2 = points[1];
        //System.out.println(index1 + " " + index2);
        char temp = word.charAt(index1);
        //word.setCharAt(index1, temp);
        word.setCharAt(index1, word.charAt(index2));
        word.setCharAt(index2, temp);
        return word;
    }

    //rotate method done and works, use replace
    public static StringBuilder rotate (StringBuilder word, int rotateNum){ 
        if(rotateNum == 0 || (rotateNum % word.length() == 0 )){
            //do nothing
        }else{
            //System.out.println("rotateNum: " + rotateNum);
            int rotations = 0;
            if(rotateNum > 0){
                rotations = rotateNum % word.length();
                //System.out.println("pos rotations:" + rotations);
                String tempStr = word.substring(0, rotations);
                //System.out.println(tempStr);
                word.delete(0, rotations);
                word.append(tempStr);
                //System.out.println("after: " + word);
            }else{
                rotations = word.length() + (rotateNum % word.length());
                //System.out.println("neg rotations:" + rotations);
                String tempStr = word.substring(0, rotations);
                //System.out.println(tempStr);
                word.delete(0, rotations);
                word.append(tempStr);
            }
        }
        return word;
    }

    //reverse method doen works
    public static StringBuilder reverse(StringBuilder word, int [] points){
        int index1 = points[0];
        int index2 = points[1];
        String lettersToReverse = word.substring(index1, index2+1);
        // System.out.println("substring to reverse: " + lettersToReverse);
        StringBuilder str = new StringBuilder(lettersToReverse);
        str.reverse();
        word.delete(index1, index2+1);
        word.insert(index1,str);
        //System.out.println("after reversed: " + word);
        return word;
    }

    //move mehtod done works!
    public static StringBuilder move(StringBuilder word, int [] points){
        int index1 = points[0];
        int index2 = points[1];
        char characterMoved = word.charAt(index1);
       // System.out.println("character to be moved: " + characterMoved + " from " + index1 + " to " + index2);
        word.delete(index1,index1+1);
       // System.out.println("index1 deleted: " + word);
        word.insert(index2,characterMoved);
        //System.out.println("insertion at " + index2 + " is " + word);
        return word;
    }

}


