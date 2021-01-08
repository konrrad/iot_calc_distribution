package model;

import static java.lang.Math.sqrt;

public class Frame {
    public double width;
    public double height;
    public double temp;
    public Branch branch;

    public Double getOptimalDistance(double factor) {
        double optimalDistance = sqrt(width*height / branch.verticesCount());
        return factor * optimalDistance;
    }

    public Double getOptimalDistance() {
        return getOptimalDistance(1);
    }
}
