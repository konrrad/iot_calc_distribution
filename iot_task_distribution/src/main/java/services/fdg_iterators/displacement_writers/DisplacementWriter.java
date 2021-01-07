package services.fdg_iterators.displacement_writers;

import model.Vertex;

import javax.vecmath.Vector2d;
import javax.vecmath.Vector3d;

public abstract class DisplacementWriter {

    protected double optimalDistance = 3;

    public DisplacementWriter(double optimalDistance) {
        this.optimalDistance = optimalDistance;
    }


    public double attrForce(double delta) {
        return delta * delta / optimalDistance;
    }

    public double repulsiveForce(double delta) {
        return -(optimalDistance * optimalDistance) / delta;
    }

    protected Vector2d calcRepForcesSum(Vector2d v, Vector2d delta) {
        delta.normalize();
        delta.scale(repulsiveForce(delta.length()));
        var displacement = new Vector2d(v);
        displacement.add(delta);
        return displacement;
    }


    protected Vector2d calcAttrForcesSum(Vector2d v, Vector2d delta) {
        delta.normalize();
        delta.scale(attrForce(delta.length()));
        var displacement = new Vector2d(v);
        displacement.add(delta);
        return displacement;
    }

    protected Vector2d calcAttrForcesSub(Vector2d v, Vector2d delta) {
        delta.normalize();
        delta.scale(attrForce(delta.length()));
        var displacement = new Vector2d(v);
        displacement.sub(delta);
        return displacement;
    }

    public abstract void writeAttrDisplacement(Vertex v1, Vertex v2);

    public abstract void writeRepDisplacement(Vertex v1, Vertex v2);

    public abstract void updateLocation(Vertex v);
}
