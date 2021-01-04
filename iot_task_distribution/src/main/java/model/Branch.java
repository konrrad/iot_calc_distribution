package model;

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
}
