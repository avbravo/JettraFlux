package io.jettra.flux.core;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Modifier applies styling and layout properties to Widgets,
 * keeping the component constructors clean.
 */
public class Modifier {
    private final Map<String, String> styles = new LinkedHashMap<>();
    private final StringBuilder classes = new StringBuilder();

    public Modifier() {}

    public Modifier padding(int all) {
        styles.put("padding", all + "px");
        return this;
    }

    public Modifier padding(int top, int right, int bottom, int left) {
        styles.put("padding", top + "px " + right + "px " + bottom + "px " + left + "px");
        return this;
    }

    public Modifier margin(int all) {
        styles.put("margin", all + "px");
        return this;
    }

    public Modifier width(String width) {
        styles.put("width", width);
        return this;
    }

    public Modifier height(String height) {
        styles.put("height", height);
        return this;
    }
    
    public Modifier fillMaxWidth() {
        styles.put("width", "100%");
        return this;
    }
    
    public Modifier fillMaxHeight() {
        styles.put("height", "100%");
        return this;
    }

    public Modifier background(String color) {
        styles.put("background-color", color);
        return this;
    }

    public Modifier cssClass(String cssClass) {
        classes.append(cssClass).append(" ");
        return this;
    }

    public Modifier style(String styleString) {
        if (styleString != null && !styleString.trim().isEmpty()) {
            String[] parts = styleString.split(";");
            for (String part : parts) {
                if (part.contains(":")) {
                    String[] kv = part.split(":");
                    if (kv.length == 2) {
                        styles.put(kv[0].trim(), kv[1].trim());
                    }
                }
            }
        }
        return this;
    }

    public String getStyles() {
        return styles.entrySet().stream()
                .map(e -> e.getKey() + ":" + e.getValue() + ";")
                .collect(Collectors.joining(" "));
    }

    public String getClasses() {
        return classes.toString().trim();
    }
}
