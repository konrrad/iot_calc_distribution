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

    public double calcDispChange(double delta) {
        return delta / Math.abs(delta) * attrForce(delta);
    }

    protected Vector3d calcRepForcesSum(Vector3d v, Vector3d delta) {
        double x = v.getX() + (delta.getX() / Math.abs(delta.getX)) * repulsiveForce(delta.getX());
        double y = v.getY() + (delta.getY() / Math.abs(delta.getY)) * repulsiveForce(delta.getY());
        double z = v.getZ() + (delta.getZ() / Math.abs(delta.getZ)) * repulsiveForce(delta.getZ());
        return new Vector3d(x, y, z);
    }


    protected Vector3d calcAttrForcesSum(Vector3d v, Vector3d delta) {
        double x = v.getX() + (delta.getX() / Math.abs(delta.getX)) * attrForce(delta.getX());
        double y = v.getY() + (delta.getY() / Math.abs(delta.getY)) * attrForce(delta.getY());
        double z = v.getZ() + (delta.getZ() / Math.abs(delta.getZ)) * attrForce(delta.getZ());
        return new Vector3d(x, y,
    }

    protected Vector3d calcAttrForcesSub(Vector3d v, Vector3d delta) {
        double x = v.getX() - (delta.getX() / Math.abs(delta.getX)) * attrForce(delta.getX());
        double y = v.getY() - (delta.getY() / Math.abs(delta.getY)) * attrForce(delta.getY());
        double z = v.getZ() - (delta.getZ() / Math.abs(delta.getZ)) * attrForce(delta.getZ());
        return new Vector3d(x, y, z);
    }

    abstract void writeAttrDisplacement(Vertex v1, Vertex v2);

    abstract void writeRepDisplacement(Vertex v1, Vertex v2);

    abstract void updateLocation(Vertex v);
}
