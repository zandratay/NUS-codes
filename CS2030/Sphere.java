class Sphere implements Shape3D {
    private final double radius;

    Sphere(double radius) {
        this.radius = radius;
    }

    protected double getRad() {
        return this.radius;
    }

    private static final double numerator = 4.0;
    private static final int denominator = 3;
    //private static final int power = 3;

    @Override
    public double volume() {
        //double numerator = 4.0;
        //double denominator = 3.0;
        //int power = 3;
        double rad = this.getRad();
        return numerator / denominator * Math.PI * rad * rad * rad;
    }

    @Override
    public String toString() {
        return "sphere [" + String.format("%.2f", this.getRad()) + "]";
    }
}
