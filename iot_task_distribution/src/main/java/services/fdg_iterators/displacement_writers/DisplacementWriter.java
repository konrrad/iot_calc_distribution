package services.fdg_iterators.displacement_writers;

import model.Vertex;

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

    protected Vector3d calcRepForcesSum(Vector3d v, Vector3d delta) {
        double x = v.getX() + (delta.getX() / delta.length()) * repulsiveForce(delta.length());
        double y = v.getY() + (delta.getY() / delta.length()) * repulsiveForce(delta.length());
        double z = v.getZ() + (delta.getZ() / delta.length()) * repulsiveForce(delta.length());
        return new Vector3d(x, y, z);
    }


    protected Vector3d calcAttrForcesSum(Vector3d v, Vector3d delta) {
        double x = v.getX() + (delta.getX() / delta.length()) * attrForce(delta.length());
        double y = v.getY() + (delta.getY() / delta.length()) * attrForce(delta.length());
        double z = v.getZ() + (delta.getZ() / delta.length()) * attrForce(delta.length());
        return new Vector3d(x, y, z);
    }

    protected Vector3d calcAttrForcesSub(Vector3d v, Vector3d delta) {
        double x = v.getX() - (delta.getX() / delta.length()) * attrForce(delta.length());
        double y = v.getY() - (delta.getY() / delta.length()) * attrForce(delta.length());
        double z = v.getZ() - (delta.getZ() / delta.length()) * attrForce(delta.length());
        return new Vector3d(x, y, z);
    }

    public abstract void writeAttrDisplacement(Vertex v1, Vertex v2);

    public abstract void writeRepDisplacement(Vertex v1, Vertex v2);

    public abstract void updateLocation(Vertex v);
}
