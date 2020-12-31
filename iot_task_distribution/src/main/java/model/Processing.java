package model;

import java.util.List;

public class Processing {
    private final List<Process> processes;

    public Processing(List<Process> processes) {
        this.processes = processes;
    }

    public List<Process> getProcesses() {
        return processes;
    }
}
