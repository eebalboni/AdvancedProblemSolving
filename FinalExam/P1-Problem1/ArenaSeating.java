/***
* Arena Seating
* Author: Emily Balboni
*
* SER305 - Spring 2023, Starting Code
* Analysis: Analyze your solution's time and (additional) space efficiency in terms of w and a.
*    k = number of cases (ignore, analyze time PER case)
*    w = the number of workers
*    a = the area of the arena (RxC)
*    Note "additional" space does not include the input itself.
*  Time: The algorithm is not very efficient. It firsts loops through all of the rectangles provided that each worker
completes. So that takes theta(w) time. Then, for each worker it loops through their individual grid, which takes o(r*c) time. 
So the time complexetiy in total would take theta(w*r*c) time. 
*  Space: I decided to use a grid of boolean values to determine how many seats were uncleaned. I made this grid 
size of the arena. Therefore, this problem takes an additional o(a) space wise as the grid is RXC in size. 
Otherwise, the solution uses variables to keep track of count of cleaned, uncleaned seats, and the total number of seats in 
the arena. 
***/
import java.util.Scanner;
import java.util.ArrayList;

public class ArenaSeating {
  public static Scanner sc;
  public static void main(String[] args) {
    sc = new Scanner(System.in);
    int k = Integer.parseInt(sc.nextLine());  // How many cases?
    for (int i = 0; i < k; i++)
    processCase();  // Process each case
  }

  static class Rectangle {
    int sr, sc;  // Start row and column
    int er, ec;  // End row and column
    Rectangle(int sr, int sc, int er, int ec) {
      this.sr = sr; this.sc = sc;
      this.er = er; this.ec = ec;
    }

    public String toString(){
      return "(" + this.sr + " " + this.sc + " " + this.er + " " + this.ec + ")";
    }
  }

  public static void processCase() {
    // Read in the number of rows and columns and workers
    int rows = sc.nextInt();
    int cols = sc.nextInt();
    int workers = sc.nextInt();
    ArrayList<Rectangle> areas = new ArrayList<>(workers);

    // Read in the dimensions chosen for each worker
    for (int i = 0; i < workers; i++) {
      int sRow = sc.nextInt();
      int sCol = sc.nextInt();
      int eRow = sc.nextInt();
      int eCol = sc.nextInt();
      Rectangle r = new Rectangle(sRow, sCol, eRow, eCol);
      areas.add(r);
    }

    long result = solve(rows, cols, areas);
    System.out.println(result);
  }

  //to solve this, what you can do is create a grid and set all the values to false
  //then you can loop through each rectangle and check first if the space has been 
  //visited, if it has move on, if not check it to true and increase the count for 
  //the number of seats that have been cleaned
  //once you reach the end, then you take the number of seats minus the number of seats 
  //cleaned to get your answer
  
  private static long solve(int rows, int cols, ArrayList<Rectangle> areas) {
    //the total seats in the arena
    int totalSeatsInArena = rows * cols;

    //total seats cleaned by the crew 
    int totalSeatsCleaned = 0;

    //total seats not cleaned
    int totalSeatsNotCleaned = 0;
    
    //to keep track of what seats were cleaned by someone to avoid duplicate counts
    boolean [][] seats = new boolean [rows][cols];

    //first looping through each rectangle
    for(int i = 0; i < areas.size(); i++){
      //getting the current rectangle
      Rectangle cur = areas.get(i);
      //getting each row and column, if it has been already cleaned move on, otherwise mark true and increase count
      for(int j = cur.sr; j < cur.er+1; j++){
        for(int k = cur.sc; k < cur.ec+1; k++){
          if(!seats[j][k]){
            seats[j][k] = true;
            totalSeatsCleaned++;
          }else{
            //do nothing!
          }
        }
      }
    }
    //calculate seats not cleaned
    totalSeatsNotCleaned = totalSeatsInArena - totalSeatsCleaned;
    return totalSeatsNotCleaned;
  }
}
