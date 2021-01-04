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
        v.add(delta);
        return new Vector2d(v);
    }


    protected Vector2d calcAttrForcesSum(Vector2d v, Vector2d delta) {
        delta.normalize();
        delta.scale(attrForce(delta.length()));
        v.add(delta);
        return new Vector2d(v);
    }

    protected Vector2d calcAttrForcesSub(Vector2d v, Vector2d delta) {
        delta.normalize();
        delta.scale(attrForce(delta.length()));
        v.sub(delta);
        return new Vector2d(v);
    }

    public abstract void writeAttrDisplacement(Vertex v1, Vertex v2);

    public abstract void writeRepDisplacement(Vertex v1, Vertex v2);

    public abstract void updateLocation(Vertex v);
}
