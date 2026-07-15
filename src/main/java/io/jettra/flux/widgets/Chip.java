package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;

public class Chip extends Widget {
    private final String label;
    private String icon;
    private String image;

    private Chip(String label) {
        this.label = label;
    }

    public static Chip of(String label) {
        return new Chip(label);
    }

    public Chip icon(String icon) {
        this.icon = icon;
        return this;
    }
    
    public Chip image(String image) {
        this.image = image;
        return this;
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-chip")).append(">\n");
        
        if (image != null && !image.isEmpty()) {
            sb.append("<img src=\"").append(image).append("\" alt=\"chip-image\" class=\"espresso-chip-image\" />\n");
        } else if (icon != null && !icon.isEmpty()) {
            sb.append("<span class=\"espresso-chip-icon\"><i class=\"").append(icon).append("\"></i></span>\n");
        }
        
        sb.append("  <span class=\"espresso-chip-text\">").append(label).append("</span>\n");
        sb.append("</div>\n");
        
        return sb.toString();
    }
}
