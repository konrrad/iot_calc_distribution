package services.fdg_iterators;

import model.Branch;

import java.util.List;

public class SimpleFdgIterator extends FdgIterator {

    public SimpleFdgIterator(Branch branch) {
        super(branch);
    }

    @Override
    protected void writeAttrDisplacements() {
        foreach(Machine m:getBranch().getMachines()){
            foreach(Machine nM:getBranch().getMachines()){
                if (m == nM) {

                }
            }
        }
        // TODO: 12/31/2020 not implemented by Staszek
    }

    @Override
    protected void writeRepDisplacements() {
        // TODO: 12/31/2020 not implemented by Staszek
    }

    @Override
    protected void updateLocations() {
        // TODO: 12/31/2020 not implemented by Staszek
    }
}
