package model;

import javax.vecmath.Vector3d;
import java.util.ArrayList;
import java.util.List;

public abstract class Vertex {
    private final Vector3d location;
    private final Vector3d displacement;
    private final List<Edge> edges = new ArrayList<>();

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

    public List<Edge> getEdges() {
        return edges;
    }
}
