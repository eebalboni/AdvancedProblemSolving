/***
* Gift Shop
* Author: Emily Balboni
*
* SER305 - Spring 2023, Starting Code
* Analysis: Analyze your solution's time and (additional) space efficiency in terms of n and c
*    k = number of cases (ignore, analyze time PER case)
*    n = the number of items
*    c = the amount of cash Boomer has
*    Note "additional" space does not incude the input itself.
*  Time: In regards to time, the solution loops through the number of items that is provided by the test case. So, at first glance, 
the solution takes theta(n) for time. However, in order to perform collections.sort, that takes n log n time. 
Therefore, the solution takes theta(n log n) time to finish. 
*  Space: In my solution there is no additional space needed. I only used a few variables to keep track of the current
item being looked at, a total for the current amount of cash, and then a counter variable for the number of items that could
be purchased. So the solution uses constant space. 
*  Explanation: 
***/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class GiftShop {
  public static Scanner sc;
  public static void main(String[] args) {
    sc = new Scanner(System.in);
    int k = Integer.parseInt(sc.nextLine());  // How many cases?
    for (int i = 0; i < k; i++)
    processCase();  // Process each case
  }

  static class Item {
    int quantity;
    double price;

    public Item(int quantity, double price) {
      this.quantity = quantity;
      this.price = price;
    }
    public String toString(){
      return "(" + this.quantity + " " + this.price + ")";
    }

  }

  public static void processCase() {
    // Read in the number of items
    int n = sc.nextInt();
    ArrayList<Item> items = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      // Get the quantity and price for each item
      int q = sc.nextInt();
      double p = sc.nextDouble();
      items.add(new Item(q, p));
    }
    // Get how much cash boomer has to spend
    double cash = sc.nextDouble();

    int maxItems = solve(cash, items);

    // Print out the max number of items
    System.out.println(maxItems);
  }
 
  //need to get least expensive item, see how many you can buy, subtract that from the curCash and move on,
  //increase count too 
  private static int solve(double cash, ArrayList<Item> items) {
      ////find the least expensive item, see how many you can buy with just the cash 
      int countOfItems = 0; //the total number of items you can buy
      double currentCash = cash; //the current amount of cash you have
      //collections sort method to sort the items from least to most expensive
      Collections.sort(items, (o1, o2) -> (o1.price < o2.price) ? -1 : (o1.price > o2.price) ? 1 : 0);
      //System.out.println("Elements of the ArrayList after" +" sorting : " + items);
      //System.out.println(cash);
      //looping through each item
      for(int i = 0; i < items.size(); i ++){
        Item curItem = items.get(i);
        if(curItem.price > currentCash){//do nothing, you can't buy something you can't afford
          //if(i == size-1) return countOfItems; //if youre on the last index you can end here
        }else{
          //how many items you can buy 
          int numCanBuy = (int)(currentCash/curItem.price);
          //System.out.println(numCanBuy);
          if(numCanBuy > curItem.quantity){ //you should not be able to buy more than whats available
            numCanBuy = curItem.quantity;
          }
          //System.out.println("item: " + curItem + "amount you can" + numCanBuy);
          currentCash = currentCash - ((numCanBuy * curItem.price));
          //System.out.println(currentCash);
          countOfItems = countOfItems + numCanBuy;
          //System.out.println();
        }
      }
      return countOfItems;
      }
    
    
  } 

