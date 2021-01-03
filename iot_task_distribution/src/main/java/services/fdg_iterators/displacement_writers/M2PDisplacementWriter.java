package services.fdg_iterators.displacement_writers;

import model.Vertex;

import javax.vecmath.Vector3d;

public class M2PDisplacementWriter extends DisplacementWriter {

    public M2PDisplacementWriter() {
        super(1);
    }

    @Override
    public void writeAttrDisplacement(Vertex v1, Vertex v2) {

    }

    @Override
    public void writeRepDisplacement(Vertex v1, Vertex v2) {
        Vector3d dif = new Vector3d(v1.getLocation());
        dif.sub(v2.getLocation());
        v1.getDisplacement().set(calcRepForcesSum());
    }

    @Override
    public void updateLocation(Vertex v) {
        // TODO: 12/31/2020 not implemented by Staszek
    }
}
