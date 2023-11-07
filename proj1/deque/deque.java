package deque;

public interface deque<Type> extends Iterable<Type> {
    // Adds an item of type T to the front of the deque. You can assume that item is never null.
    public void addFirst(Type item);

    //Adds an item of type T to the back of the deque. You can assume that item is never null.
    public void addLast(Type item);

    //Returns true if deque is empty, false otherwise.
    default public boolean isEmpty(){
        return size()==0;
    }

    //Returns the number of items in the deque.
    public int size();

    // Prints the items in the deque from first to last, separated by a space. Once all the items have been printed, print out a new line
    public void printDeque();


    //Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public Type removeFirst();

    //Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public Type removeLast();

    //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
    public Type get(int index);

    //Two special methods
    /*The Deque objects we’ll make are iterable (i.e. Iterable<T>)
    so we must provide this method to return an iterator.*/
//    public Iterator<Type> iterator();

    /* Returns whether or not the parameter o is equal to the Deque.
    o is considered equal if it is a Deque and if it contains the same
    contents (as goverened by the generic T’s equals method) in the same
     order. (ADDED 2/12: You’ll need to use the instance of keywords for
     this.*/
    public boolean equals(Object o);
}
