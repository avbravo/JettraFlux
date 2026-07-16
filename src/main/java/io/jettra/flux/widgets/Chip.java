package io.jettra.flux.widgets;
import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
public class Chip extends Widget {
    private final String label;
    private String icon;
    private String image;
    private Widget removeIcon; // optional
    private Chip(String label) { this.label = label; }
    public static Chip of(String label) { return new Chip(label); }
    public Chip icon(String icon) { this.icon = icon; return this; }
    public Chip image(String image) { this.image = image; return this; }
    public Chip removable(boolean removable) { 
        if(removable) this.removeIcon = Icon.of("fas fa-times-circle"); 
        return this; 
    }
    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        String style = "display: inline-flex; align-items: center; background: rgba(128,128,128,0.1); color: var(--text-color); border-radius: 16px; padding: 0.3rem 0.75rem; font-size: 0.875rem; font-weight: 500; gap: 0.5rem;";
        if (image != null && !image.isEmpty()) {
            style = style.replace("padding: 0.3rem 0.75rem;", "padding: 0 0.75rem 0 0;");
        }
        sb.append("<div ").append(renderCommonAttributes(theme, "espresso-chip")).append(" style=\"").append(style).append("\">\n");

        if (image != null && !image.isEmpty()) {
            sb.append("<img src=\"").append(image).append("\" alt=\"chip-image\" style=\"width: 2rem; height: 2rem; border-radius: 50%; object-fit: cover; margin-right: 0.5rem;\" />\n");
        } else if (icon != null && !icon.isEmpty()) {
            if (icon.startsWith("<svg")) {
                sb.append("<span style=\"margin-right: 0.5rem; display: flex; align-items: center;\">").append(icon).append("</span>\n");
            } else {
                sb.append("<span style=\"margin-right: 0.5rem; display: flex; align-items: center;\"><i class=\"").append(icon).append("\"></i></span>\n");
            }
        }

        sb.append("<span>").append(label).append("</span>\n");
        if (removeIcon != null) {
            sb.append("<span style=\"cursor:pointer; margin-left: 0.25rem; font-size:1rem; opacity:0.6;\">").append(removeIcon.render(theme)).append("</span>");
        }
        sb.append("</div>\n");
        return sb.toString();
    }
}
