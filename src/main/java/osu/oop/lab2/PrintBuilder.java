package osu.oop.lab2;

import java.util.LinkedHashMap;
import java.util.Map;

public class PrintBuilder {
    private Map<String, String> fields = new LinkedHashMap<>();

    public PrintBuilder PrintBuilder() {
        return this;
    }

    public PrintBuilder addField(String field, Object value) {
        fields.put(field, String.valueOf(value));
        return this;
    }

    public String build() {
        StringBuilder stringBuilder = new StringBuilder();
        fields.forEach((field, value) -> {
            stringBuilder
                    .append(field)
                    .append(" = ")
                    .append(value)
                    .append(", ");
        });
        stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");
        return stringBuilder.toString();
    }


}
