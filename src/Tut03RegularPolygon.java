public class Tut03RegularPolygon {
    private int n = 3;
    private double side = 1.0;

    Tut03RegularPolygon() {
    }

    Tut03RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
    }

    public int getN(){
        return this.n;
    }
    public void setN(int n){
        if(n>=3){
            this.n=n;
        }else{
            System.out.println("n should >= 3!");
        }
    }

    public double getSide(){
        return this.side;
    }
    public void setSide(double side){
        if(side>=0){
            this.side=side;
        }else{
            System.out.println("n should >= 0!");
        }
    }

    public double getPerimeter(){
        return this.n*this.side;
    }

    public double getArea(){
        return (this.n*Math.pow(this.side,2)/(4.0*Math.tan(Math.PI/this.n)));
    }
}
