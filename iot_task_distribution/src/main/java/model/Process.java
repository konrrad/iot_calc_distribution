package model;

import javax.vecmath.Vector3d;

public class Process extends Vertex{

    private final int neededRam;

    public Process(Vector3d location, int neededRam) {
        super(location);
        this.neededRam = neededRam;
    }

    public int getNeededRam() {
        return neededRam;
    }
}
