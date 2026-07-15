package io.jettra.flux.core;

import java.util.ArrayList;
import java.util.List;

/**
 * JSBuilder provides a Fluent API to generate JavaScript code dynamically.
 */
public class JSBuilder {
    private final List<String> lines = new ArrayList<>();

    public static JSBuilder create() {
        return new JSBuilder();
    }

    public JSBuilder addFunction(String functionName, String params, String body) {
        lines.add("function " + functionName + "(" + params + ") {\n" + body + "\n}");
        return this;
    }

    public JSBuilder addFunction(String functionName, String body) {
        return addFunction(functionName, "", body);
    }
    
    public JSBuilder addStatement(String statement) {
        lines.add(statement + (statement.endsWith(";") ? "" : ";"));
        return this;
    }

    public JSBuilder addRaw(String rawJs) {
        lines.add(rawJs);
        return this;
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append("<script>\n");
        for (String line : lines) {
            sb.append(line).append("\n");
        }
        sb.append("</script>\n");
        return sb.toString();
    }
}
