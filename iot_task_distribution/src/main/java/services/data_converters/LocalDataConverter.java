package services.data_converters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Branch;

import java.lang.reflect.Type;
import java.util.List;

public class LocalDataConverter implements DataConverter {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Branch jsonToModel(String json) {
        Type type = new TypeToken<Branch>(){}.getType();
        return gson.fromJson(json, type);
    }

    @Override
    public String modelToJson(Branch branch) {
        return gson.toJson(branch);
    }
}
