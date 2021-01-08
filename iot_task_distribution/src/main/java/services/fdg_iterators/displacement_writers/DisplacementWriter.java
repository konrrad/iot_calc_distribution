package services.fdg_iterators.displacement_writers;

import model.Frame;
import model.Vertex;

import javax.vecmath.Vector2d;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static services.utils.VectorUtils.normalize;

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
        delta = max(delta, 0.1);
        return (optimalDistance * optimalDistance) / delta;
    }

    protected Vector2d calcRepForcesSum(Vector2d v, Vector2d delta) {
        var deltaLength = delta.length();
        normalize(delta);
        delta.scale(repulsiveForce(deltaLength));
        var displacement = new Vector2d(v);
        displacement.add(delta);
        return displacement;
    }


    protected Vector2d calcAttrForcesSum(Vector2d v, Vector2d delta) {
        var deltaLength = delta.length();
        normalize(delta);
        delta.scale(attrForce(deltaLength));
        var displacement = new Vector2d(v);
        displacement.add(delta);
        return displacement;
    }

    protected Vector2d calcAttrForcesSub(Vector2d v, Vector2d delta) {
        var deltaLength = delta.length();
        normalize(delta);
        delta.scale(attrForce(deltaLength));
        var displacement = new Vector2d(v);
        displacement.sub(delta);
        return displacement;
    }

    public void writeAttrDisplacement(Vertex v1, Vertex v2) {
        Vector2d delta = new Vector2d(v1.getLocation());
        delta.sub(v2.getLocation());
        v1.getDisplacement().set(calcAttrForcesSub(v1.getDisplacement(), new Vector2d(delta)));
        v2.getDisplacement().set(calcAttrForcesSum(v2.getDisplacement(), new Vector2d(delta)));
    }

    public void writeRepDisplacement(Vertex v1, Vertex v2) {
        Vector2d delta = new Vector2d(v1.getLocation());
        delta.sub(v2.getLocation());
        v1.getDisplacement().set(calcRepForcesSum(v1.getDisplacement(), new Vector2d(delta)));
    }

    public void updateLocation(Vertex v) {
        var trueDisp = new Vector2d(
                min(v.getDisplacement().x, temp),
                min(v.getDisplacement().y, temp)
        );
        var disp = v.getDisplacement();
        normalize(disp);
        trueDisp.set(
                disp.x * trueDisp.x,
                disp.y * trueDisp.y
        );
        v.getLocation().add(trueDisp);
        v.getLocation().set(
                min(width * 0.5, max(-width / 2, v.getLocation().x)),
                min(height * 0.5, max(-height / 2, v.getLocation().y))
        );
    }

    public static DisplacementWriter of(Frame frame) {
        return new M2MDisplacementWriter(frame.getOptimalDistance(), frame.temp, frame.width, frame.height);
    }


    public void cool() {
        temp -= temp * 0.05;
        temp = max(0, temp);
    }
}
