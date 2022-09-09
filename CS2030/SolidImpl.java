class SolidImpl implements Solid {
    private final Shape3D shape;
    private final double density;

    SolidImpl(Shape3D shape, double density) {
        this.shape = shape;
        this.density = density;
    }

    private Shape3D getShape() {
        return this.shape;
    }

    private double getDensity() {
        return this.density;
    }

    @Override
    public double volume() {
        return this.getShape().volume();
    }

    @Override
    public double mass() {
        return this.getShape().volume() * this.getDensity();
    }

    @Override
    public String toString() {
        return "SolidImpl";
    }
}
