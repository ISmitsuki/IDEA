class Apple extends Fruit{
    public static void main(String[] args) {
        Apple myApple = new Apple();
        System.out.println(myApple); //.toString
    }
}

class Fruit {
    public Fruit(String name){
        System.out.println("2invoked");
    }

    public Fruit(){
        System.out.println("1invoked"); //work
    }
}

