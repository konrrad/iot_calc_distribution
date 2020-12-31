package services.fdg_iterators.displacement_writers;

import model.Vertex;

public interface DisplacementWriter {
    Void writeAttrDisplacement(Vertex v1, Vertex v2);
    Void writeRepDisplacement(Vertex v1, Vertex v2);
    Void updateLocation(Vertex v);
}
