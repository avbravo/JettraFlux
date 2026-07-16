package io.jettra.flux.widgets;

import io.jettra.flux.core.Widget;
import io.jettra.flux.theme.ThemeData;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class WidgetLet extends Widget {
    private String title;
    private String icon;
    private final List<WidgetLet> children = new ArrayList<>();
    private Widget actionWidget;
    private String url;
    private String id;

    public WidgetLet(String title) {
        this.title = title;
        this.id = "wl_" + UUID.randomUUID().toString().replace("-", "");
    }

    public static WidgetLet of(String title) {
        return new WidgetLet(title);
    }

    public WidgetLet icon(String iconClass) {
        this.icon = iconClass;
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

    public String getTitle() { return title; }
    public String getUrl() { return url; }
    public String getIcon() { return icon; }
    public List<WidgetLet> getChildren() { return children; }

    @Override
    public String render(ThemeData theme) {
        StringBuilder sb = new StringBuilder();
        
        sb.append("<div class=\"widgetlet-item\" style=\"padding: 8px; margin-left: 10px;\">");
        
        sb.append("<div style=\"display: flex; align-items: center; cursor: pointer; justify-content: space-between;\" ");
        if (url != null && !url.isEmpty()) {
            sb.append("onclick=\"window.location.href='").append(url).append("'\" ");
        } else if (!children.isEmpty()) {
            String storageKey = "menu_exp_" + title.replaceAll("[^a-zA-Z0-9]", "_").toLowerCase();
            sb.append("onclick=\"var el = document.getElementById('").append(id).append("_children'); ")
              .append("var icon = document.getElementById('").append(id).append("_icon'); ")
              .append("var isHidden = el.style.display === 'none'; ")
              .append("el.style.display = isHidden ? 'block' : 'none'; ")
              .append("icon.className = isHidden ? 'fas fa-chevron-down' : 'fas fa-chevron-right'; ")
              .append("localStorage.setItem('").append(storageKey).append("', isHidden ? 'open' : 'closed');\" ");
        }
        sb.append(">");
        
        sb.append("<div style=\"display: flex; align-items: center;\">");
        if (icon != null && !icon.isEmpty()) {
            sb.append("<span style=\"margin-right: 8px;\">").append(Icon.of(icon).render(theme)).append("</span>");
        }
        sb.append("<span style=\"font-weight: bold;\">").append(title).append("</span>");
        sb.append("</div>");
        
        if (actionWidget != null) {
            sb.append("<div style=\"margin-left: 10px;\">").append(actionWidget.render(theme)).append("</div>");
        } else if (!children.isEmpty()) {
            sb.append("<span style=\"margin-left: 10px; color: #888;\"><i id=\"").append(id).append("_icon\" class=\"fas fa-chevron-right\"></i></span>");
        }
        
        sb.append("</div>");

        if (!children.isEmpty()) {
            String storageKey = "menu_exp_" + title.replaceAll("[^a-zA-Z0-9]", "_").toLowerCase();
            sb.append("<div id=\"").append(id).append("_children\" class=\"widgetlet-children\" style=\"display: none; margin-left: 15px; border-left: 1px solid rgba(0,0,0,0.1); padding-left: 10px; margin-top: 5px;\">");
            for (WidgetLet child : children) {
                sb.append(child.render(theme));
            }
            sb.append("</div>");
            sb.append("<script>if(localStorage.getItem('").append(storageKey).append("') === 'open') { ")
              .append("document.getElementById('").append(id).append("_children').style.display = 'block'; ")
              .append("document.getElementById('").append(id).append("_icon').className = 'fas fa-chevron-down'; } </script>");
        }
        
        sb.append("</div>");
        return sb.toString();
    }
}
