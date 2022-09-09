private static final double EPSILON = 1e-15;


Circle createUnitCircle(Point p, Point q) {
    Point m = p.midPoint(q);
    double theta = p.angleTo(q);
    double mq = m.distanceTo(q);
    double mc = Math.sqrt(1 - mq * mq);
    double newAngle = theta + Math.PI / 2;
    Point c = m.moveTo(newAngle, mc);
    return new Circle(c, 1.0);
}

int findMaxDiscCoverage(List<Point> points) {
    int maxDiscCoverage = 0;

    for (int i = 0; i < points.size() - 1; i++) {
        for (int j = i + 1; j < points.size(); j++) {
            Point p = points.get(i);
            Point q = points.get(j);
            double dist = p.distanceTo(q);

            if (dist < 2.0 + EPSILON && dist > 0.0) {
                Circle c1 = createUnitCircle(p, q);

                int coverage = 0;

                for (Point point : points) {
                    if (c1.contains(point)) {
                        coverage = coverage + 1;
                    }
                } 

                if (coverage > maxDiscCoverage) {
                    maxDiscCoverage = coverage;
                }
            }
        }
    }
    
    return maxDiscCoverage;
}

