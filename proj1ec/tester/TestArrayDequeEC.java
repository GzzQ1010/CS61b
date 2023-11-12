package tester;
import static org.junit.Assert.*;
import org.junit.Test;
import student.StudentArrayDeque;
import edu.princeton.cs.algs4.StdRandom;

public class TestArrayDequeEC {
    @Test
    public void add100ThenRemoveFirst100Test(){
        StudentArrayDeque<Integer> List1= new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> List2= new ArrayDequeSolution<>();
        for(int i=0;i<100   ; i++){
            Integer randNum= StdRandom.uniform(0,100);
            if(i<=50){
                List1.addFirst(randNum);
                List2.addFirst(randNum);
                assertEquals(List1.get(i),List2.get(i));
            }else {
                List1.addLast(randNum);
                List2.addLast(randNum);
            }
        }
        for(int i=0; i<100;i++){
            int randNum= StdRandom.uniform(0,100);
            if(i<50){
                assertEquals(List1.removeFirst(),List2.removeFirst());
            }else{
                Integer Expect=List2.removeLast(), Actual=List1.removeLast();

                assertEquals(Expect,Actual);
            }
        }
    }

}
