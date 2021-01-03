package services.fdg_iterators;

import model.Branch;
import model.Machine;
import model.Process;

public class SimpleFdgIterator extends FdgIterator {

    public SimpleFdgIterator(Branch branch) {
        super(branch);
    }

    @Override
    protected void writeAttrDisplacements() {
        for (Machine m : branch.getMachines()) {
            m.getDisplacement().set(0, 0, 0);
            for (Machine nM : branch.getMachines()) {
                if (m != nM) {
                    m2mDisplacementWriter.writeAttrDisplacement(m, nM);
                }
            }
        }
        for (Machine m : branch.getMachines()) {
            m.getDisplacement().set(0, 0, 0);
            for (Process p : branch.getProcessing().getProcesses()) {
                m2pDisplacementWriter.writeAttrDisplacement(m, p);
            }
        }
    }

    @Override
    protected void writeRepDisplacements() {
        for (Machine m : branch.getMachines()) {
            m.getDisplacement().set(0, 0, 0);
            for (Machine nM : branch.getMachines()) {
                if (m != nM) {
                    m2mDisplacementWriter.writeRepDisplacement(m, nM);
                }
            }
        }
        for (Machine m : branch.getMachines()) {
            m.getDisplacement().set(0, 0, 0);
            for (Process p : branch.getProcessing().getProcesses()) {
                m2pDisplacementWriter.writeRepDisplacement(m, p);
            }
        }
    }

    @Override
    protected void updateLocations() {
        for (Machine m : branch.getMachines()) {
            m2mDisplacementWriter.updateLocation(m);
        }
        for (Process m : branch.getProcessing().getProcesses()) {
            m2pDisplacementWriter.updateLocation(m);
        }
    }
}
