package services.data_converters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Frame;

import java.lang.reflect.Type;

public class LocalDataConverter implements DataConverter {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Frame jsonToModel(String json) {
        Type type = new TypeToken<Frame>(){}.getType();
        return gson.fromJson(json, type);
    }

    @Override
    public String modelToJson(Frame frame) {
        return gson.toJson(frame);
    }
}
