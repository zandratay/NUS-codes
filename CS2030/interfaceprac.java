interface Shape {
    double getArea(); // Shape interface is implemented as a "contract"
    // only specifies the methods to be defined in the implementation class
}
class Circle implements Shape {
    private final double radius;
    Circle(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }
}
class Rectangle implements Shape {
    private final int length, breadth;
    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }
    @Override
    public double getArea() {
        return this.length * this.breadth * 1.0;
    }
}

public class interfaceprac {
    public static void main(String[] args) {
        Circle c1 = new Circle(1.2);
        Rectangle r1 = new Rectangle(2, 3);
        System.out.println(c1.getArea());
        System.out.println(r1.getArea());
    }
}
