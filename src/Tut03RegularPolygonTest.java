public class Tut03RegularPolygonTest {
    public static void main(String[] args) {
        Tut03RegularPolygon polygon1 = new Tut03RegularPolygon();
        System.out.println("The regular Polygon n: " + polygon1.getN() +
                ", side: " + polygon1.getSide() +
                ", Area: " + polygon1.getArea() +
                ", Perimeter: " + polygon1.getPerimeter());

        Tut03RegularPolygon polygon2 = new Tut03RegularPolygon(6, 4.0);
        System.out.println("The regular Polygon n: " + polygon2.getN() +
                ", side: " + polygon2.getSide() +
                ", Area: " + polygon2.getArea() +
                ", Perimeter: " + polygon2.getPerimeter());
    }
}
