import java.util.List;

class Point {
    private final double x, y;
    // constructor --> this is a method too!
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    // getter
    // any getters should have PRIVATE access
    private double getX() {
        return this.x;
    }
    private double getY() {
        return this.y;
    }
    // this keyword -> notion to a self
    // call a method through an existing object (OOP)
    double distanceTo(Point otherpoint) {
        double disx = this.getX() - otherpoint.x;
        double disy = this.getY() - otherpoint.y;
        return Math.sqrt(disx * disx + disy * disy);
    }

    /// every object SHOULD have a toString method. this is the standard way to writw it
    @Override
    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + ")";
    }
    // this is bad!! there is no way to decvelp one class at a time. need both point and circle class together
    // CYCLIC DEPENDENCIES -- bad!!
    boolean isContainedIn(Circle c) {
        return c.origin.distanceTo(this) < c.radius;
    }
    //double findMaxDistance(List<Point> points) {
    //    double maxDist = 0.0;
    //    for(int i = 0; i < points.size(); i++) {
    //        for(int j = 1; points.size(); j++) {
    //            if (Math.abs(points.get(i) - points.get(j)) > maxDist) {
    //                maxDist = Math.abs(points.get(i) - points.get(j));
    //           }
    //        }
    //   }
    //    return maxDist;
    //}
}

class Circle {
    private final Point origin; //center
    private final double radius;
    Circle(Point origin, double radius) {
        this.origin = origin;
        this.radius = radius;
    }
    private Point getOrigin() {
        return this.origin;
    }
    private double getRadius() {
        return this.radius;
    }
    @Override
    public String toString() {
        return "centre: " + this.origin + "and radius: " + this.radius;
    }
    double area() {
      return Math.PI * this.getRadius() * this.getRadius();
    }
    Circle setRadius(double newRadius) {
        return new Circle(this.getOrigin(), newRadius);
    }
    boolean containsPoint(Point point) {
        return this.getOrigin().distanceTo(point) < this.getRadius();
    } 
    // if state mutating -> return new object instead!!
    // will not affect original object
    Circle scale(double factor) {
        return new Circle(this.origin, this.radius * factor);
    }

}
public class point2 {
    public static void main(String[] args) {
        Point p1 = new Point(0.0, 0.0);
        Point p2 = new Point(1.0, 1.0);
        Point p3 = new Point(4.0, 4.0);
        System.out.println(p1.distanceTo(p2));

        // note 2 different outputs below
        System.out.println(p3); // get a point
        System.out.println(p3.toString()); // get a string

        Circle c1 = new Circle(p1, 3.2);
        System.out.println(c1.toString());
        System.out.println(c1.containsPoint(p3));
        System.out.println(c1.containsPoint(new Point(10.0, 10.0)));
     }
}
