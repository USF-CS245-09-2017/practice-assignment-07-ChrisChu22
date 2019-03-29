public class LinkedList<Item> implements List<Item>{

    //node class for making nodes
    public class Node <Item>
    {
        //instance data
        Node next;
        Item data;

        //constructor
        public Node(Item data)
        {
            this.data = data;
            next = null;
        } //Node

        public void setNext(Node next)
        {
            this.next = next;
        } //setNext


        public Node getNext()
        {
            return this.next;
        } //getNext

        public Item getData()
        {
            return this.data;
        } //getData

    } //Node

    //instance data
    Node head;
    int size;

    //constructors
    public LinkedList()
    {
        head = null;
        size = 0;
    }

    //adds a node to the linked list
    @Override
    public void add(Item item)
    {
        //if there is no item in the linked list, then make head the given item
        if (head == null)
        {
            Node newNode = new Node(item);
            head = newNode;
            size++;
        } //if
        //moves nodes over by one and then add given item to linked list
        else
        {
            Node prev = head;
            while(prev.getNext() != null)
                prev = prev.getNext();
            Node NewNode = new Node(item);
            prev.setNext(NewNode);
            size++;
        } //else
    } //add

    //adds an item to a specific position
    @Override
    public void add(int pos, Item item)
    {
        //adds the item to the head if the position is 0
        if (pos == 0)
        {
            Node node = new Node(item);
            node.setNext(head);
            head = node;
            size++;
        } //if
        //moves all the items before the given position over and adds the node into the given position
        else
        {
            size++;
            Node prev = head;
            for (int i = 0; i < pos - 1; i++)
                prev = prev.getNext();
            Node node = new Node(item);
            node.setNext(prev.getNext());
            prev.setNext(node);
        } //else

    } //add

    //goes through the linked list until it gets to the given position and then returns that item
    @Override
    public Item get(int pos)
    {
        Node curr = head;
        for (int i = 0; i < pos; i++)
            curr = curr.getNext();
        return (Item) curr.getData();
    } //get

    //removes the item at the given position
    @Override
    public Item remove(int pos)
    {
        //if the head is the first item then it changes the head to the next value
        if (pos == 0)
        {
            Node curr = head;
            head = curr.getNext();
            --size;
            return (Item) curr.getData();
        } //if

        //else prev goes through the linked list until it gets to the position and removes that item
        else
        {
            Node prev = head;
            for (int i = 0; i < pos-1; i++)
                prev = prev.getNext();
            Node curr = prev.getNext();
            prev.setNext(curr.getNext());
            --size;
            return (Item) curr.getData();
        } //else
    } //remove

    //returns the size of linked list
    @Override
    public int size()
    {
        return size;
    } //size
}