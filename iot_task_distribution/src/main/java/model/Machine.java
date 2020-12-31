package model;

import javax.vecmath.Vector3d;
import java.util.ArrayList;
import java.util.List;

public class Machine extends Vertex {

    private final int ram;
    private final MachineType type;
    private final List<Process> processes = new ArrayList<>();

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

    public List<Process> getProcesses() {
        return processes;
    }
}
