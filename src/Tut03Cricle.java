public class Tut03Cricle {
    double radius = 0;
    static int numOfCircle = 0;

    Tut03Cricle(int radius){
        this.radius = radius;
        Tut03Cricle.numOfCircle++;
    }

    double getArea(){
        return radius*radius*Math.PI;
    }

    public static void main(String[] args){

        Tut03Cricle Circle1 = new Tut03Cricle(1);
        Tut03Cricle Circle2 = new Tut03Cricle(2);
        Tut03Cricle Circle3 = new Tut03Cricle(3);
        System.out.printf("Total %d circles created.\n", Tut03Cricle.numOfCircle);


        Tut03Cricle[] circles = new Tut03Cricle[3];//只new了array
        for (int i=0; i<3; i++){
            circles[i] = new Tut03Cricle(i); //为数组中的每个元素分配内存空间，不然是null
            double area = circles[i].getArea();
            System.out.println(area);
        }
    }
}
