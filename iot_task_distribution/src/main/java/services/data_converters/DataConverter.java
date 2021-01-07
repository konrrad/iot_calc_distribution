package services.data_converters;

import model.Frame;

public interface DataConverter {
    Frame jsonToModel(String json);
    String modelToJson(Frame frame);
}
