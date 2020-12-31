package model;

import javax.vecmath.Vector3d;
import java.util.ArrayList;
import java.util.List;

public class Machine extends Vertex {
    private final int ram;
    private final MachineType type;
    // Initially machine does not contain any placed processes
    private final List<Process> placedProcesses = new ArrayList<>();

    public Machine(Vector3d location, int ram, MachineType type) {
        super(location);
        this.ram = ram;
        this.type = type;
    }

    public int getRam() {
        return ram;
    }

    public MachineType getType() {
        return type;
    }

    public List<Process> getPlacedProcesses() {
        return placedProcesses;
    }
}
