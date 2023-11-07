package deque;

import org.junit.Test;




import static org.junit.Assert.*;

public class LinedListDequeTest {
    @Test
    public void addFirstTest(){
        LinkedListDeque<Integer> List3= new LinkedListDeque<Integer>();
        List3.addFirst(1);
        List3.addFirst(2);
        assertEquals(2,List3.size());
        assertEquals(2,(int)List3.get(1));
    }
    @Test
    public void addLastTest(){
        LinkedListDeque<Integer> List3= new LinkedListDeque<Integer>(1);
        List3.addFirst(2);
        List3.addFirst(3);
        List3.addLast(4);
        assertEquals(4,List3.size());
        assertEquals(4,(int)List3.get(List3.size()));
    }

    @Test
    public void getTest(){
        LinkedListDeque<Integer> List1= new LinkedListDeque<Integer>(1);
        List1.addFirst(2);
        List1.addFirst(3);
        List1.addLast(4);
        List1.addLast(5);
        List1.addLast(6);
        assertEquals(1,(int)List1.get(3));
        assertEquals(4,(int)List1.get(4));
    }

    @Test
    public void removeFirstTest(){
        LinkedListDeque<Integer> List1= new LinkedListDeque<Integer>(1);
        List1.addFirst(2);
        List1.addFirst(3);
        List1.addLast(4);
        List1.addLast(5);
        List1.addLast(6);
        assertEquals(3,(int)List1.get(1));
        List1.removeFirst();
        assertEquals(2,(int)List1.get(1));
        assertEquals(5,List1.size());
    }
    @Test
    public void removeLastTest(){
        LinkedListDeque<Integer> List1= new LinkedListDeque<Integer>(1);
        List1.addFirst(2);
        List1.addFirst(3);
        List1.addLast(4);
        List1.addLast(5);
        List1.addLast(6);
        assertEquals(3,(int)List1.get(1));
        List1.removeLast();
        assertEquals(5,(int)List1.get(List1.size()));
        assertEquals(5,List1.size());
    }


}
