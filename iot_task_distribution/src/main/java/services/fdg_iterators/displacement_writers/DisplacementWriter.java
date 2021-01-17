package services.fdg_iterators.displacement_writers;

import model.Frame;
import model.Vertex;

import javax.vecmath.Vector2d;

import static java.lang.Math.max;

public class DisplacementWriter {

    protected final double optimalDistance;

    protected double temp;

    protected final double width;
    protected final double height;

    public DisplacementWriter(double optimalDistance, double temp, double width, double height) {
        this.optimalDistance = optimalDistance;
        this.temp = temp;
        this.width = width;
        this.height = height;
    }


    public double attrForce(double delta) {
        return delta * delta / optimalDistance;
    }

    public double repulsiveForce(double delta) {
        return (optimalDistance * optimalDistance) / delta;
    }

    public void writeAttrDisplacement(Vertex v1, Vertex v2) {
        // normalized difference position vector of v and u
        Vector2d deltaPos = new Vector2d();
        deltaPos.sub(v1.getLocation(), v2.getLocation());
        double length = deltaPos.length();
        deltaPos.normalize();

        // displacements depending on attractive force
        deltaPos.scale(attrForce(length));

        v1.getDisplacement().sub(deltaPos);
        v2.getDisplacement().add(deltaPos);
    }

    public void writeRepDisplacement(Vertex v1, Vertex v2) {
        // normalized difference position vector of v and u
        Vector2d deltaPos = new Vector2d();
        deltaPos.sub(v1.getLocation(), v2.getLocation());
        double length = deltaPos.length();
        deltaPos.normalize();

        // displacement depending on repulsive force
        deltaPos.scale(repulsiveForce(length));
        v1.getDisplacement().add(deltaPos);
    }

    public void updateLocation(Vertex v) {
        Vector2d disp = new Vector2d(v.getDisplacement());
        double length = disp.length();

        // limit maximum displacement by temperature
        disp.normalize();
        disp.scale(Math.min(length, temp));
        v.getLocation().add(disp);

        // prevent being displaced outside the frame
        v.getLocation().x = Math.min(width, Math.max(0.0, v.getLocation().x));
        v.getLocation().y = Math.min(width, Math.max(0.0, v.getLocation().y));
    }

    public static DisplacementWriter of(Frame frame) {
        return new M2MDisplacementWriter(frame.getOptimalDistance(), frame.temp, frame.width, frame.height);
    }


    public void cool() {
        temp -= temp * 0.05;
        temp = max(0, temp);
    }

    public Double getTemp() {
        return temp;
    }
}
