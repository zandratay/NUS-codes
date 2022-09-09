//public class MaxDiscCoverage {
    
    private static final double EPSILON = 1e-15;

    /*
     * method to find maximum no. of points that a unit circle can cover
    */
    int findMaxDiscCoverage(List<Point> points) { 
        int maxDiscCoverage = 0;

        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = i + 1; j < points.size(); j++) {
                Point p = points.get(i);
                Point q = points.get(j);
                double dist = p.distanceTo(q);

                if (dist < 2.0 + EPSILON && dist > 0.0) {
                    Circle c1 = Circle.createUnitCircle(p, q);
                    
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

    /*
     * main method
    */
//    public static void main(String[] args) {
        
//    }
//}
