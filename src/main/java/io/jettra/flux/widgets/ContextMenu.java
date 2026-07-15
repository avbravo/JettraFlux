package io.jettra.flux.widgets;
import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.Arrays;
import java.util.List;
public class ContextMenu extends Widget {
    private final List<WidgetLet> items;
    private ContextMenu(List<WidgetLet> items) { this.items = items; }
    public static ContextMenu of(WidgetLet... items) { return new ContextMenu(Arrays.asList(items)); }
    @Override public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder("<div ").append(renderCommonAttributes(theme, "menu-ContextMenu")).append(" style=\"display:flex; gap:15px; background:var(--surface-color); padding:10px; border-radius:8px; border:1px solid rgba(128,128,128,0.2);\">");
        for (WidgetLet item : items) {
            sb.append(item.render(theme));
        }
        sb.append("</div>");
        return sb.toString();
    }
}
