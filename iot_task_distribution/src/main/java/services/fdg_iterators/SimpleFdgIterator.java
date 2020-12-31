package services.fdg_iterators;

import model.Branch;

import java.util.List;

public class SimpleFdgIterator extends FdgIterator{

    public SimpleFdgIterator(List<Branch> branches) {
        super(branches);
    }

    @Override
    protected void writeAttrDisplacements() {
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
