package model;

import javax.vecmath.Vector3d;
import java.util.ArrayList;
import java.util.List;

public class Machine extends Vertex {
    private int ram;
    private MachineType type;
    // Initially machine does not contain any placed processes
    private final List<Process> placedProcesses = new ArrayList<>();

    public Machine() {
        super();
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
