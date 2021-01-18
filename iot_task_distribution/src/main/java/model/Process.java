package model;

import javax.vecmath.Vector2d;
import javax.vecmath.Vector3d;

public class Process extends Vertex {

    private int neededRam;

    public Process() {
        super();
    }

    public int getNeededRam() {
        return neededRam;
    }

    public Process(Process p)
    {
        super(p.getLocation());
        this.location=p.location;
        this.neededRam=p.neededRam;
    }

    public Process(Vector2d location, int neededRam)
    {
        this.neededRam=neededRam;
        this.location=location;
    }
}
