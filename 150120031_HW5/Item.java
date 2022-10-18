/* The purpose of this program is to calculate the revenue, paid salaries and produced 
   total items according to employee's work hour and speed.*/

// Þükrü Can Mayda - 150120031


public class Item {

    private int id;

    public static int numberOfItems;

    // Increase the number of items.
    public Item(int id) {
        this.id = id;
        numberOfItems++;
    }
}