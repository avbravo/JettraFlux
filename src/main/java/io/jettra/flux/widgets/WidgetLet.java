package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.ArrayList;
import java.util.List;

public class WidgetLet extends Widget {
    private String title;
    private String icon;
    private final List<WidgetLet> children = new ArrayList<>();
    private Widget actionWidget;
    private String url;

    public WidgetLet(String title) {
        this.title = title;
    }

    public static WidgetLet of(String title) {
        return new WidgetLet(title);
    }

    public WidgetLet icon(String icon) {
        this.icon = icon;
        return this;
    }

    public WidgetLet url(String url) {
        this.url = url;
        return this;
    }

    public WidgetLet add(WidgetLet child) {
        this.children.add(child);
        return this;
    }
    
    public WidgetLet action(Widget widget) {
        this.actionWidget = widget;
        return this;
    }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("<div class=\"widgetlet-item\" style=\"padding: 8px; margin-left: 10px;\">");
        
        sb.append("<div style=\"display: flex; align-items: center; cursor: pointer;\" ");
        if (url != null) {
            sb.append("onclick=\"window.location.href='").append(url).append("'\" ");
        }
        sb.append(">");
        
        if (icon != null && !icon.isEmpty()) {
            sb.append("<span style=\"margin-right: 8px;\">").append(icon).append("</span>");
        }
        sb.append("<span style=\"font-weight: bold;\">").append(title).append("</span>");
        
        if (actionWidget != null) {
            sb.append("<div style=\"margin-left: auto;\">").append(actionWidget.render(theme)).append("</div>");
        }
        
        sb.append("</div>");

        if (!children.isEmpty()) {
            sb.append("<div class=\"widgetlet-children\" style=\"margin-left: 15px; border-left: 1px solid #ccc; padding-left: 10px;\">");
            for (WidgetLet child : children) {
                sb.append(child.render(theme));
            }
            sb.append("</div>");
        }
        
        sb.append("</div>");
        return sb.toString();
    }
}
