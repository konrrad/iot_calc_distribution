package services.data_converters;

import model.Frame;

import static java.lang.Math.random;

public class GeoGebraConverter implements DataConverter {
    @Override
    public Frame jsonToModel(String json) {
        return null;
    }

    @Override
    public String modelToJson(Frame frame) {
        StringBuilder builder = new StringBuilder();
        builder.append("Execute[{");
        frame.branch.getProcessing().getProcesses().forEach((p) -> {
            builder
                    .append("\"P")
                    .append((int) (10 / random()))
                    .append(" = ")
                    .append(p.getLocation())
                    .append("\",");
        });
        frame.branch.getMachines().forEach((m) -> {
            builder
                    .append("\"")
                    .append(m.getType().toString().charAt(0))
                    .append(" = ")
                    .append(m.getLocation())
                    .append("\",");
        });
        builder.append("}]");
        char[] result = builder.toString().toCharArray();
        result[result.length - 3] = ' ';
        return new String(result);
    }
}
