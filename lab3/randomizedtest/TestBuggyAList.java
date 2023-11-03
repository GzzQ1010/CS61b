package randomizedtest;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> NoResizeList= new AListNoResizing<Integer>();
        BuggyAList<Integer> BuggyAlist= new BuggyAList<Integer>();
        NoResizeList.addLast(4);
        NoResizeList.addLast(5);
        NoResizeList.addLast(6);
        BuggyAlist.addLast(4);
        BuggyAlist.addLast(5);
        BuggyAlist.addLast(6);
        assertEquals(NoResizeList.removeLast(),BuggyAlist.removeLast());
        assertEquals(NoResizeList.removeLast(),BuggyAlist.removeLast());
        assertEquals(NoResizeList.removeLast(),BuggyAlist.removeLast());
    }
    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L1 = new AListNoResizing<>();
        BuggyAList<Integer> L2= new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);//StdRandom.uniform(0, 2) function returns a random integer in the range [0, 2),
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L1.addLast(randVal);
                L2.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                assertEquals(L1.size(),L2.size());
                System.out.println("size method ran.");
            }else if(operationNumber==2 && L1.size()>0){
                assertEquals(L1.getLast(),L2.getLast());
                System.out.println("getLast ran.");
            }else if(operationNumber==3 && L1.size()>0) {
                assertEquals(L1.removeLast(),L2.removeLast());
                System.out.println("removeLast ran; the size1:"
                        +L1.size() + "the size2: "+L2.size() );
            }
        }
    }
}
