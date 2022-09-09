class SolidSphere extends Sphere {
    private final double density;

    SolidSphere(double radius, double density) {
        super(radius);
        this.density = density;
    }

    private double getDensity() {
        return this.density;
    }

    public double mass() {
        SolidImpl solidimp = new SolidImpl(this, this.getDensity());
        return solidimp.mass();
    }

    @Override
    public String toString() {
        return "solid-sphere [" + String.format("%.2f", super.getRad()) + "] with a mass of " +
            String.format("%.2f", this.mass());
    }
}
