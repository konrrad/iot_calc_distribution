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
        for (Machine m : frame.branch.getMachines()) {
            for (Machine nM : frame.branch.getMachines()) {
                if (m != nM) {
                    m2mDisplacementWriter.writeAttrDisplacement(m, nM);
                }
            }
        }
        for (Machine m : frame.branch.getMachines()) {
            for (Process p : frame.branch.getProcessing().getProcesses()) {
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
