package model;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private Processing processing;
    private List<Machine> machines;

    public Processing getProcessing() {
        return processing;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public int processesCount() {
        return processing.getProcesses().size();
    }

    public int machinesCount() {
        return machines.size();
    }

    public int verticesCount() {
        return processesCount() + machinesCount();
    }

    public List<Vertex> getAllVertices() {
        var all = new ArrayList<Vertex>();
        all.addAll(processing.getProcesses());
        all.addAll(machines);
        return all;
    }
}
