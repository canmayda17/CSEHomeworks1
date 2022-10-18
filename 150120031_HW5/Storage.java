/* The purpose of this program is to calculate the revenue, paid salaries and produced 
   total items according to employee's work hour and speed.*/

// Þükrü Can Mayda - 150120031

public class Storage {

	// Defining.
    private int capacity;
    private Item[] Items;

    public Storage (int capacity) {
        this.capacity = capacity;

        Items = new Item[0];
    }


    // Adding items.
    public void addItem (Item item) {

        Item[] tempItem = Items;
        Items = new Item[tempItem.length + 1];

        for (int i = 0; i < tempItem.length; i++) {
            Items[i] = tempItem[i];
        }

        Items[Items.length - 1] = item;
    }

    // Getting items.
    public Item[] getItems() {
        return Items;
    }


}