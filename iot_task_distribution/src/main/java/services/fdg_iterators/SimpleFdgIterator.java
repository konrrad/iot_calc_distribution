package services.fdg_iterators;

import model.Machine;
import model.Process;
import model.Frame;

public class SimpleFdgIterator extends FdgIterator {

    public SimpleFdgIterator(Frame frame) {
        super(frame);
    }

    @Override
    protected void writeAttrDisplacements() {
        var machines = frame.branch.getMachines();
        var processes = frame.branch.getProcessing().getProcesses();

        for (int i = 0; i < machines.size() - 1; i++) {
            m2mDisplacementWriter.writeAttrDisplacement(machines.get(i), machines.get(i+1));
        }
        for (int i = 0; i < processes.size() - 1; i++) {
            m2mDisplacementWriter.writeAttrDisplacement(processes.get(i), processes.get(i+1));
        }
        for (Machine m : machines) {
            for (Process p : processes) {
                m2pDisplacementWriter.writeAttrDisplacement(m, p);
            }
        }
    }

    @Override
    protected void writeRepDisplacements() {
        for (Machine m : frame.branch.getMachines()) {
            m.getDisplacement().set(0, 0);
            for (Machine nM : frame.branch.getMachines()) {
                if (m != nM) {
                    m2mDisplacementWriter.writeRepDisplacement(m, nM);
                }
            }
            for (Process p : frame.branch.getProcessing().getProcesses()) {
                m2pDisplacementWriter.writeRepDisplacement(m, p);
            }

        }
    }

    @Override
    protected void updateLocations() {
        for (Machine m : frame.branch.getMachines()) {
            m2mDisplacementWriter.updateLocation(m);
        }
        for (Process p : frame.branch.getProcessing().getProcesses()) {
            m2pDisplacementWriter.updateLocation(p);
        }
    }
}
