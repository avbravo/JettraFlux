package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;

public class Badge extends Widget {
    private final String text;
    private String severity = "info";

    private Badge(String text) {
        this.text = text;
    }

    public static Badge of(String text) {
        return new Badge(text);
    }

    public Badge severity(String severity) {
        this.severity = severity;
        return this;
    }

    @Override
    public String render(ThemeData theme) {
        String baseCssClass = "espresso-badge badge " + severity;
        StringBuilder sb = new StringBuilder();
        sb.append("<span ").append(renderCommonAttributes(theme, baseCssClass)).append(">");
        sb.append(text);
        sb.append("</span>");
        return sb.toString();
    }
}
