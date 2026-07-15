package io.jettra.flux.widgets;
import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
public class Badge extends Widget {
    private final String text;
    private String severity = "primary";
    private String icon = null;
    private String size = "normal";

    private Badge(String text) { this.text = text; }
    public static Badge of(String text) { return new Badge(text); }
    public Badge severity(String severity) { this.severity = severity; return this; }
    public Badge icon(String icon) { this.icon = icon; return this; }
    public Badge size(String size) { this.size = size; return this; }

    @Override
    public String render(ThemeData theme) {
        String bgColor = "var(--primary-color)";
        String color = "white";
        switch (severity.toLowerCase()) {
            case "success": bgColor = "#22c55e"; break;
            case "info": bgColor = "#3b82f6"; break;
            case "warning": bgColor = "#eab308"; color = "#1e293b"; break;
            case "danger": bgColor = "#ef4444"; break;
            case "secondary": bgColor = "#64748b"; break;
            case "primary": default: bgColor = "var(--primary-color, #3b82f6)"; break;
        }
        String minW = "1.5rem", h = "1.5rem", fontS = "0.75rem";
        if ("large".equalsIgnoreCase(size) || "lg".equalsIgnoreCase(size)) { minW = "1.75rem"; h = "1.75rem"; fontS = "0.875rem"; }
        else if ("xlarge".equalsIgnoreCase(size) || "xl".equalsIgnoreCase(size)) { minW = "2rem"; h = "2rem"; fontS = "1rem"; }

        String style = "display: inline-flex; align-items: center; justify-content: center; min-width: " + minW + "; height: " + h + "; padding: 0 0.5rem; font-size: " + fontS + "; font-weight: 700; border-radius: 12px; background-color: " + bgColor + "; color: " + color + "; gap: 0.3rem;";
        StringBuilder sb = new StringBuilder();
        sb.append("<span ").append(renderCommonAttributes(theme, "espresso-badge")).append(" style=\"").append(style).append("\">");
        if (icon != null && !icon.isEmpty()) {
            sb.append("<i class=\"").append(icon).append("\"></i>");
        }
        if (text != null && !text.isEmpty()) {
            sb.append("<span>").append(text).append("</span>");
        }
        sb.append("</span>");
        return sb.toString();
    }
}
