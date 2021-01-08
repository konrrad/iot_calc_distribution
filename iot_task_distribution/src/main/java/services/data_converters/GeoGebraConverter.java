package services.data_converters;

import model.Frame;

/**
 * Result can be pasted into the https://www.geogebra.org/graphing input to see
 * vertices.
 */
public class GeoGebraConverter implements DataConverter {
    @Override
    public Frame jsonToModel(String json) {
        return null;
    }

    @Override
    public String modelToJson(Frame frame) {
        StringBuilder builder = new StringBuilder();
        builder.append("Execute[{");
        for (int i = 0; i < frame.branch.getProcessing().getProcesses().size(); i++) {
            var p = frame.branch.getProcessing().getProcesses().get(i);
            builder
                    .append("\"P")
                    .append(i)
                    .append(" = ")
                    .append(p.getLocation())
                    .append("\",");
        }
        for (int i = 0; i < frame.branch.getMachines().size(); i++) {
            var m = frame.branch.getMachines().get(i);
            builder
                    .append("\"")
                    .append(m.getType().toString().charAt(0))
                    .append(i)
                    .append(" = ")
                    .append(m.getLocation())
                    .append("\",");
        }
        builder.append("}]");
        char[] result = builder.toString().toCharArray();
        result[result.length - 3] = ' ';
        return new String(result);
    }
}
