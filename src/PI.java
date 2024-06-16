import java.util.Random;

public class PI {
    public static void main(String[] args) {
        int n=0;

        Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            double x = rand.nextDouble()*2-1;
            double y = rand.nextDouble()*2-1;
            if(x*x+y*y<=1){
                n++;
            }
        }
        //P=pi/4...pi=4P
        double pi=4*n/10000.0;
        System.out.println(pi);
    }
}
