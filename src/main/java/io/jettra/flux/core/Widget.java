package io.jettra.flux.core;

import io.jettra.flux.theme.ThemeData;
import java.util.UUID;

/**
 * The base class for all UI elements in JettraEspressoUI.
 * Inspired by Flutter's Widget and Jetpack Compose's @Composable.
 */
public abstract class Widget {
    protected String id;
    protected Modifier modifier = new Modifier();
    protected java.util.function.Consumer<Object> onClick;

    public Widget() {
        this.id = "esp-" + UUID.randomUUID().toString().substring(0, 8);
    }

    public Widget modifier(Modifier modifier) {
        this.modifier = modifier;
        return this;
    }

    public Widget attribute(String key, String value) {
        this.modifier.attribute(key, value);
        return this;
    }

    public Widget onClick(java.util.function.Consumer<Object> onClick) {
        this.onClick = onClick;
        return this;
    }

    public String getId() {
        return id;
    }

    /**
     * Renders this widget to an HTML string using the provided theme.
     */
    public abstract String render(ThemeData theme);

    /**
     * Helper to render common attributes like id, classes, styles, and onClick handlers.
     */
    protected String renderCommonAttributes(ThemeData theme, String defaultClasses) {
        StringBuilder sb = new StringBuilder();
        sb.append("id=\"").append(id).append("\" ");
        
        String finalClasses = defaultClasses + " " + modifier.getClasses();
        if (!finalClasses.trim().isEmpty()) {
            sb.append("class=\"").append(finalClasses.trim()).append("\" ");
        }

        String finalStyles = modifier.getStyles();
        if (!finalStyles.isEmpty()) {
            sb.append("style=\"").append(finalStyles).append("\" ");
        }

        if (onClick != null) {
            sb.append("onclick=\"espressoFire('").append(id).append("')\" ");
        }
        
        for (java.util.Map.Entry<String, String> entry : modifier.getAttributes().entrySet()) {
            sb.append(entry.getKey()).append("=\"").append(entry.getValue()).append("\" ");
        }

        return sb.toString();
    }
}
