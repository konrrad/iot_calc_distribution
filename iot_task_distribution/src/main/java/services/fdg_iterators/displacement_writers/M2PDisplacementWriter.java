package services.fdg_iterators.displacement_writers;

import model.Vertex;

import javax.vecmath.Vector2d;
import javax.vecmath.Vector3d;

public class M2PDisplacementWriter extends DisplacementWriter {

    public M2PDisplacementWriter() {
        super(10);
    }

    @Override
    public void writeAttrDisplacement(Vertex v1, Vertex v2) {
        Vector2d delta = new Vector2d(v1.getLocation());
        delta.sub(v2.getLocation());
        v1.getDisplacement().set(calcAttrForcesSub(v1.getLocation(), delta));
        v2.getDisplacement().set(calcAttrForcesSum(v2.getLocation(), delta));
    }

    @Override
    public void writeRepDisplacement(Vertex v1, Vertex v2) {
        Vector2d delta = new Vector2d(v1.getLocation());
        delta.sub(v2.getLocation());
        v1.getDisplacement().set(calcRepForcesSum(v1.getLocation(), delta));
    }

    @Override
    public void updateLocation(Vertex v) {
        v.getDisplacement().normalize();
        v.getLocation().add(v.getDisplacement());
    }
}
