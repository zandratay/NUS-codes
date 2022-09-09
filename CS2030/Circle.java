class  Circle {
    private final Point centre;
    private final double radius;

    Circle(Point centre, double radius) {
        this.centre = centre;
        this.radius = radius;
    }

    private double getRad() {
        return this.radius;
    }

    private Point getCentre() {
        return this.centre;
    }

    private static final double epsilon = 1e-15;

    boolean contains(Point p) {
        return this.getCentre().distanceTo(p) < this.getRad() + epsilon;
    }

    @Override
    public String toString() {
        return "circle of radius " + this.getRad() + " centred at " + this.getCentre();
    }
}
