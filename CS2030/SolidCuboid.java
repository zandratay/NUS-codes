class SolidCuboid extends Cuboid implements Solid {
    private final double density;

    SolidCuboid(double height, double width, double length, double density) {
        super(height, width, length);
        this.density = density;
    }

    private double getDensity() {
        return this.density;
    }

    @Override
    public double mass() {
        SolidImpl solidimp = new SolidImpl(this, this.getDensity());
        return solidimp.mass();
    }

    @Override
    public String toString() {
        return "solid-cuboid [" + String.format("%.2f", this.getH()) + " x " +
            String.format("%.2f", this.getW()) + " x " + String.format("%.2f", this.getL()) +
            "] with a mass of " + String.format("%.2f", this.mass());
    }
}
