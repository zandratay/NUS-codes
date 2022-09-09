class Circle {
    protected final double radius; // protected gives access to properties / methods to ALL other classes (not only sub classes) within the same package
    Circle(double radius) {
        this.radius = radius;
    }
    double getArea() {
        return Math.PI * this.radius * this.radius;
    }
    public String toString() {
        return "circle with area " + String.format("%2f", this.getArea());
    }
    String toString(String emoticon) { // methods of the same name can co-exist if thir method signatures (number, type, order of args) differ
        return "Circle of radius: " + this.radius + emoticon;
    }
}

// filledCircle <: Circle
class filled extends Circle {
    private final String color;
    filled(double radius, String color) {
        super(radius); // calling parent's properties i.e. super.radius = radius
        this.color = color;
   } 
    filled fillColor(String color) {
        return new filled(super.radius, color);
    }
    @Override
    public String toString() { // defining a toString method in a sub-class overrides the one that is inherited from the parent class
        return "filled circle with area " + String.format("%2f", this.getArea());
    }
}
public class filledcircle {
    public static void main(String[] args) {
        Circle c1 = new Circle(1.2);
        System.out.println(c1.getArea());
        filled f1 = new filled(1.2, "red");
        
        System.out.println(f1.toString());
        System.out.println(f1.toString(":)"));
    }
}
