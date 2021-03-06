package model;

import javax.vecmath.Vector2d;

import static java.lang.StrictMath.random;


public abstract class Vertex {
    protected Vector2d location;
    protected final Vector2d displacement;

    public Vertex() {
        location = new Vector2d(random(), random());
        displacement = new Vector2d(0, 0);
    }

    public Vertex(Vector2d location) {
        this.location = location;
        // Initially the displacement is zero
        this.displacement = new Vector2d(0, 0);
    }

    public Vector2d getLocation() {
        return location;
    }

    public Vector2d getDisplacement() {
        return displacement;
    }
}
