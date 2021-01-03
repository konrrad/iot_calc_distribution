package model;

import javax.vecmath.Vector3d;
import java.util.ArrayList;
import java.util.List;

import static java.lang.StrictMath.random;


public abstract class Vertex {
    private final Vector3d location;
    private final Vector3d displacement;

    public Vertex() {
        location = new Vector3d(random(), random(), random());
        displacement = new Vector3d(0,0,0);
    }

    public Vertex(Vector3d location) {
        this.location = location;
        // Initially the displacement is zero
        this.displacement = new Vector3d(0, 0, 0);
    }

    public Vector3d getLocation() {
        return location;
    }

    public Vector3d getDisplacement() {
        return displacement;
    }
}
