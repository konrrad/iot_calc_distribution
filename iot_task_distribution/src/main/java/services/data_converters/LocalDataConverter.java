package services.data_converters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Branch;

import java.lang.reflect.Type;
import java.util.List;

public class LocalDataConverter implements DataConverter {
    private final Gson gson = new Gson();

    @Override
    public List<Branch> jsonToModel(String json) {
        Type type = new TypeToken<List<Branch>>(){}.getType();
        return gson.fromJson(json, type);
    }

    @Override
    public String modelToJson(List<Branch> branches) {
        return gson.toJson(branches);
    }
}
