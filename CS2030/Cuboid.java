class Cuboid implements Shape3D {
    private final double height;
    private final double width;
    private final double length;

    Cuboid(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    protected double getH() {
        return this.height;
    }  

    protected double getW() {
        return this.width;
    }

    protected double getL() {
        return this.length;
    }

    @Override 
    public double volume() {
        return this.getL() * this.getW() * this.getH();
    }

    @Override
    public String toString() {
        return "cuboid [" + String.format("%.2f", this.getH()) + " x " +
            String.format("%.2f", this.getW()) + " x " + String.format("%.2f", this.getL()) + "]";
    }
}
