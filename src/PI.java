import java.util.Random;
import java.util.Scanner;

public class PI {
    public static void main(String[] args) {
        //input - scanner
        //input: n,int,number of iter
        Scanner reader = new Scanner(System.in);
        System.out.println("please enter the iter number: ");
        int iterNum=reader.nextInt();

        //double PI=computePI(n)
        double estiPI = computePI(iterNum);

        //verify estimated PI ~= true PI = Math.PI
        double diff = (estiPI-Math.PI);

        //print things out: Estimated PI value, diff
        System.out.println("Estimated PI = "+ estiPI + ", Diff = " + diff);
    }

    public static double computePI(int iterNum_){
        int counter = 0;
        double PI=0;
        for (int i = 0; i < iterNum_; i++) {
            //take random samples
            double xPos = Math.random();
            double yPos = Math.random();

            //verify condition
            if (Math.sqrt((xPos * xPos) + (yPos * yPos)) <= 1) {
                counter++;
            }
        }
        PI = 4.0*counter/iterNum_;
        return PI;
    }

}
