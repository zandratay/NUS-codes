class Point {
    private final double x;
    private final double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    private double getX() {
        return this.x;
    }

    private double getY() {
        return this.y;
    }

    @Override
    public String toString() {
        double xx = this.getX();
        double yy = this.getY();
        return "point (" + String.format("%.3f", xx) + ", " + String.format("%.3f", yy) + ")";
    }
    //Point p1 = new Point(-1.0, 0.0);
    //System.out.println(p1.toString());

    public Point midPoint(Point p) {
        double xx = p.getX() + this.getX();
        //String xMP = String.format("%.3f", xx / 2);
        double yy = p.getY() + this.getY();
        //String yMP = String.format("%.3f", yy / 2);
        return new Point(xx / 2, yy / 2);
    }

    public double angleTo(Point p) {
        //Point coordOfLine = midPoint(p, q);
        //String angle = String.format("%.3f", Math.atan2(coordOfLine.getX(), coordOfLine.getY()));
        return Math.atan2(p.getY() - this.getY(), p.getX() - this.getX());
    }

    public double distanceTo(Point q) {
        double dispX = this.getX() - q.getX();
        double dispY = this.getY() - q.getY();
        return Math.sqrt(dispX * dispX + dispY * dispY);
    }

    public Point moveTo(double angle, double distance) {
        double xCoord = this.getX() + distance * Math.cos(angle);
        double yCoord = this.getY() + distance * Math.sin(angle);
        //String xC = String.format("%.3f", xCoord);
        //String yC = String.format("%.3f", yCoord);
        return new Point(xCoord, yCoord);
    }
}

