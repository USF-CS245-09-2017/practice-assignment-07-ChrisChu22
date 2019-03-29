import java.awt.event.ItemEvent;

public class ArrayList<Item> implements List<Item>
{
    //instance data
    Item[] arr;
    int size = 0;
    int max = 10;

    //constructor to make an arry of 10 items
    public ArrayList()
    {
        arr = (Item[]) new Object[max];
    } //ArrayList

    //function to add an item to the array
    @Override
    public void add(Item item)
    {
        if (arr.length == size)
            doubleArr();
        arr[size++] = item;
    } //add

    //function to add an item to the array at a specific position
    @Override
    public void add(int pos, Item item)
    {
        if (arr.length == size)
            doubleArr();

        for (int i = size; i > pos; i--)
            arr[i] = arr[i-1];
        arr[pos] = item;
        size++;

    } //add

    //returns the item at given position
    @Override
    public Item get(int pos)
    {
        return arr[pos];
    } //get

    //holds the item that is going to be removed in a temp variable and then shifts all items over and then returns item
    @Override
    public Item remove(int pos)
    {
        Item temp = arr[pos];
        for (int i = pos; i < size-1; i++)
            arr[i] = arr[i+1];
        size--;
        return temp;
    } //remove

    //return size of array
    @Override
    public int size()
    {
        return size;
    } //size

    //doubles the array when the array gets full
    public void doubleArr()
    {
        Item[] tempArr = (Item[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++)
        {
            tempArr[i] = arr[i];
        }
        arr = tempArr;
    } //doubleArr

} //ArrayList