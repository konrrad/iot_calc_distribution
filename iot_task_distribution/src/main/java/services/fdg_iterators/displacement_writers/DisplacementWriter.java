package services.fdg_iterators.displacement_writers;

import model.Vertex;

public interface DisplacementWriter {
    void writeAttrDisplacement(Vertex v1, Vertex v2);
    void writeRepDisplacement(Vertex v1, Vertex v2);
    void updateLocation(Vertex v);
}
