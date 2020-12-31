package services.data_converters;

import model.Branch;

import java.util.List;

public interface DataConverter {
    List<Branch> jsonToModel(String json);
    String modelToJson(List<Branch> branches);
}
