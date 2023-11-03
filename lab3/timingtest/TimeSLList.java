package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        SLList<Integer> myList= new SLList<Integer>();
        AList<Integer> Ns= new AList<Integer>();
        AList<Double> times = new AList<Double>();
        AList<Integer> opCounts= new AList<Integer>();
        int i=0;
        while(i<=128000){
            myList.addLast(5);
            i++;
            if (i==1000||i==2000||i==4000||i==8000||i==16000||i==32000||i==64000||i==128000){
                Stopwatch sw = new Stopwatch();
                for(int j=0;j<1000;j++){
                    myList.getLast();
                }
                times.addLast(sw.elapsedTime());
                Ns.addLast(i);
                opCounts.addLast(1000);
            }
        }
        printTimingTable(Ns,times,opCounts);


    }

}
