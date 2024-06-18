public class TestSwap {
    //Pass by value
    public static void swap1(int n1,int n2){
        int temp=n1;
        n1=n2;
        n2=temp;
    }

    //Pass by reference
    public static void swap2(Integer n3,Integer n4){
        Integer temp=n3;
        n3=n4;
        n4=temp;
    }

    public static void main(String[] args) {
        int x1=1,y1=2;
        Integer x2=1,y2=2;
        swap1(x1,y1);
        System.out.print(x1);
        System.out.println(y1);
        swap2(x2,y2);
        System.out.print(x2);
        System.out.println(y2);
    }
}

//输出结果都是12，Integer对象的值是不可变的