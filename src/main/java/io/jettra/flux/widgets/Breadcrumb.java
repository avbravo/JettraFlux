package io.jettra.flux.widgets;
import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.Arrays;
import java.util.List;
public class Breadcrumb extends Widget {
    private final List<String> items;
    private Breadcrumb(List<String> items) { this.items = items; }
    public static Breadcrumb of(String... items) { return new Breadcrumb(Arrays.asList(items)); }
    @Override public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder("<nav ").append(renderCommonAttributes(theme, "breadcrumb-nav")).append("><ol style=\"list-style:none; padding:0; display:flex; gap:8px; margin:0;\">");
        for (int i = 0; i < items.size(); i++) {
            sb.append("<li style=\"color: var(--primary-color);\">").append(items.get(i)).append("</li>");
            if (i < items.size() - 1) sb.append("<li>/</li>");
        }
        sb.append("</ol></nav>");
        return sb.toString();
    }
}
