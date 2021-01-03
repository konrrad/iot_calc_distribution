package services.data_converters;

import model.Branch;

import java.util.List;

public interface DataConverter {
    Branch jsonToModel(String json);
    String modelToJson(Branch branch);
}
